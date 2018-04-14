<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/vendor/bootstrap/css/bootstrap.min.css" />
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/css/blog-post.css" />
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/vendor/editor/editormd.min.css" />

		<title>Bran blog</title>
	</head>

	<body>
		<!-- Navigation -->
		<jsp:include page="bloginclude/blognav.jsp"/>

		<!-- Page Content -->
		<div class="container">

			<div class="row">

				<!-- Post Content Column -->
				<div class="col-lg-8">

					<!-- Title -->
					<h1 class="mt-4" id="blog-title"></h1>

					<!-- Author -->
					<p class="lead">
						by
						<a href="#" id="blog-author"></a>
					</p>

					<hr>

					<!-- Date/Time -->
					<p>Posted on <span id="blog-posttime"></span></p>

					<hr>

					<!-- Preview Image -->
					<img class="img-fluid rounded" src="https://source.unsplash.com/random/750x300"  height="300"/>

					<hr>

					<!-- Post Content -->
					<div id="blog-content">

					</div>

					<hr>

					<!-- Comments Form -->
					<div class="card my-4">
						<h5 class="card-header">Leave a Comment:</h5>
						<div class="card-body">
							<form>
								<div class="form-group">
									<textarea class="form-control" rows="3"></textarea>
								</div>
								<button type="submit" class="btn btn-primary">Submit</button>
							</form>
						</div>
					</div>

					<!-- Single Comment -->
					<div class="media mb-4">
						<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
						<div class="media-body">
							<h5 class="mt-0">Commenter Name</h5> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
						</div>
					</div>

					<!-- Comment with nested comments -->
					<div class="media mb-4">
						<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
						<div class="media-body">
							<h5 class="mt-0">Commenter Name</h5> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.

							<div class="media mt-4">
								<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
								<div class="media-body">
									<h5 class="mt-0">Commenter Name</h5> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
								</div>
							</div>

							<div class="media mt-4">
								<img class="d-flex mr-3 rounded-circle" src="http://placehold.it/50x50" alt="">
								<div class="media-body">
									<h5 class="mt-0">Commenter Name</h5> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis. Fusce condimentum nunc ac nisi vulputate fringilla. Donec lacinia congue felis in faucibus.
								</div>
							</div>

						</div>
					</div>

				</div>

				<!-- Sidebar Widgets Column -->
				<div class="col-md-4">

					<!-- Search Widget -->
					<div class="card my-4">
						<h5 class="card-header">Search</h5>
						<div class="card-body">
							<div class="input-group">
								<input type="text" class="form-control" placeholder="Search for...">
								<span class="input-group-btn">
                  <button class="btn btn-secondary" type="button">Go!</button>
                </span>
							</div>
						</div>
					</div>

					<!-- Categories Widget -->
					<div class="card my-4">
						<h5 class="card-header">Categories</h5>
						<div class="card-body">
							<div class="row">
								<div class="col-lg-6">
									<ul class="list-unstyled mb-0">
										<li>
											<a href="#">Web Design</a>
										</li>
										<li>
											<a href="#">HTML</a>
										</li>
										<li>
											<a href="#">Java</a>
										</li>
									</ul>
								</div>
								<div class="col-lg-6">
									<ul class="list-unstyled mb-0">
										<li>
											<a href="#">JavaScript</a>
										</li>
										<li>
											<a href="#">CSS</a>
										</li>
										<li>
											<a href="#">Tutorials</a>
										</li>
									</ul>
								</div>
							</div>
						</div>
					</div>

					<!-- Side Widget -->
					<div class="card my-4">
						<h5 class="card-header">Promotion</h5>
						<div class="card-body">This site was built on Aliyun Cloud Platform. <br/>Click
							<a href="https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=qwh4ptrk&utm_source=qwh4ptrk">here</a>
							for my promotion code
						</div>
					</div>

				</div>

			</div>
			<!-- /.row -->

		</div>
		<!-- /.container -->

		<!-- Footer -->
		<jsp:include page="bloginclude/blogfoot.jsp"/>

		<script src="${path}/blogStatic/vendor/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/blogStatic/vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/blogStatic/vendor/marked.min.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
			var rendererMD = new marked.Renderer();
			marked.setOptions({
				renderer: rendererMD,
				gfm: true,
				tables: true,
				breaks: false,
				pedantic: false,
				sanitize: false,
				smartLists: true,
				smartypants: false
			});

			function render(m) {
				$("#blog-title").html(m.title);
				$("#blog-author").html(m.author);
				$("#blog-posttime").html(generateDate(m.posttime));
				$("#blog-content").html(marked(m.content));
			}
			function generateDate(d){
				var time=d.month+" "+d.dayOfMonth+","+d.year;
				return time;
			}
			
			function fetch() {
				$.ajax({
					type: "get",
					url: "${path}/fetchblog/${blogid}",
					async: true,
					dataType:"json",
					success: function(json) {
						if(json.status == "1") {
							render(json.umessage);
						} else {
							alert(json.message);
						}
					}
				});
			}
			//call on load 
			fetch();
		</script>
	</body>

</html>