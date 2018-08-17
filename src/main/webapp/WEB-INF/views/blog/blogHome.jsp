<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Bran blog</title>

<!-- Bootstrap core CSS -->
<link rel="stylesheet" type="text/css"
	href="${path}/blogStatic/vendor/bootstrap/css/bootstrap.min.css" />

<!-- Custom fonts for this template -->
<link rel="stylesheet" type="text/css"
	href="${path}/static/assets/css/font-awesome.min.css" />
<link
	href='https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic'
	rel='stylesheet' type='text/css'>
<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800'
	rel='stylesheet' type='text/css'>

<!-- Custom styles for this template -->
<link rel="stylesheet" type="text/css"
	href="${path}/blogStatic/css/clean-blog.min.css" />
</head>

<body>
	<!-- Navigation -->
	<nav class="navbar navbar-expand-lg navbar-light fixed-top"
		id="mainNav">
		<div class="container">
			<a class="navbar-brand" href="${path }/blogEdit">Start Your Blog</a>
			<button class="navbar-toggler navbar-toggler-right" type="button"
				data-toggle="collapse" data-target="#navbarResponsive"
				aria-controls="navbarResponsive" aria-expanded="false"
				aria-label="Toggle navigation">
				Menu <i class="fa fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarResponsive">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a class="nav-link"
						href="${path}/profile">主页</a></li>
					<li class="nav-item"><a class="nav-link" href="${path}/blogEdit">写文章</a></li>
					<c:if test="${not empty user}">
						<li class="nav-item"><a class="nav-link" href="${path}/blogPersonal/${user.userId}">我的主页</a></li>
					</c:if>
					<c:if test="${empty user}" >
						<li class="nav-item"><a class="nav-link" href="${path}/login">我的主页</a></li>
					</c:if>
					
					<li class="nav-item"><a class="nav-link" href="${path}/searchPage">发现</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<!-- Page Header -->
	<header class="masthead"
		style="background-image: url('blogStatic/img/blog-bg.jpg')">
		<div class="overlay"></div>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<div class="site-heading">
						<h1>Bran Blog</h1>
						<span class="subheading">Stay Foolish , Stay Hungary</span>
					</div>
				</div>
			</div>
		</div>
	</header>

	<!-- Main Content -->
	<div class="container">
		<div class="row">
			<div class="col-lg-8 col-md-10 mx-auto" id="preview">
			
			</div>
			
			<!--pager-->
			<div class="col-lg-8 col-md-10 mx-auto">
				<div class="clearfix">
					<button class="btn btn-primary float-right" onclick="loadMoreBlogs()" id="moreBtn">More Posts &rarr;</button>
				</div>
			</div>
		</div>
	</div>
	<hr>

	<!-- Footer -->
	<footer>
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-md-10 mx-auto">
					<ul class="list-inline text-center">
						<!--<li class="list-inline-item">
	                <a href="#">
	                  <span class="fa-stack fa-lg">
	                    <i class="fa fa-circle fa-stack-2x"></i>
	                    <i class="fa fa-twitter fa-stack-1x fa-inverse"></i>
	                  </span>
	                </a>
	              </li>
	              <li class="list-inline-item">
	                <a href="#">
	                  <span class="fa-stack fa-lg">
	                    <i class="fa fa-circle fa-stack-2x"></i>
	                    <i class="fa fa-facebook fa-stack-1x fa-inverse"></i>
	                  </span>
	                </a>
	              </li>-->
						<li class="list-inline-item"><a
							href="https://github.com/BranSummer"> <span
								class="fa-stack fa-lg"> <i
									class="fa fa-circle fa-stack-2x"></i> <i
									class="fa fa-github fa-stack-1x fa-inverse"></i>
							</span>
						</a></li>
					</ul>
					<p class="copyright text-muted">Copyright &copy; Bran blog 2018</p>
				</div>
			</div>
		</div>
	</footer>

	<!-- Bootstrap core JavaScript -->
	<script src="${path }/blogStatic/vendor/jquery/jquery.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script
		src="${path}/blogStatic/vendor/bootstrap/js/bootstrap.bundle.min.js"
		type="text/javascript" charset="utf-8"></script>
	<!-- Custom scripts for this template -->
	<script src="${path }/blogStatic/js/clean-blog.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			<%-- blog总数 --%>
			var blogNum=${blogNum};
			
			<%-- 当前页面最后一篇blog的索引 --%>
			var blogIndex=0;  
			
			function generateDate(d){
				var time=d.month+" "+d.dayOfMonth+","+d.year;
				return time;
			}
		
			function addItem(m) {
				var previewDiv = $('<div></div>');
				previewDiv.addClass('post-preview');

				var link1 = $('<a></a>');
				var a1 = '/branroom/blogPostPage/'+ m.id;
				link1.attr('href', a1);
				previewDiv.append(link1);
				var titleDiv = $('<h2></h2>');
				titleDiv.addClass('post-title');
				titleDiv.text(m.title);
				var subtitleDiv = $('<h3></h3>');
				subtitleDiv.addClass('post-subtitle');
				subtitleDiv.text(m.pretext);
				link1.append(titleDiv);
				link1.append(subtitleDiv);

				var link2 = $('<a></a>');
				a2 = '/branroom/blogPersonal/' + m.author;
				link2.attr('href', a2);
				link2.text(m.author);
				var doc = $('<p></p>');
				doc.append(link2);
				var metaData = 'Posted by ' + doc.html() + ' on ' + generateDate(m.posttime);
				var postMetaDiv = $('<p></p>');
				postMetaDiv.addClass('post-meta');
				postMetaDiv.append(metaData);
				previewDiv.append(postMetaDiv);

				
				$("#preview").append(previewDiv);
				$("#preview").append("<hr>")
				
				<%-- blog index加一 --%>
				blogIndex++;
			}
			
			function addAll(list) {
				$.each(list, function(index, item) {
					addItem(item);
				});
			}
			
			function initialPage(){
				$("#preview").empty();
				$.ajax({
					type:"get",
					url:"${path}/fetchBlogs",
					async:true,
					dataType:"json",
					success:function(json){
						if(json.status=='1'){
							addAll(json.umessage);
						}
					}
				});
			}
			
			function loadMoreBlogs(){
				if(blogIndex>=blogNum){
					return false;
				}
				
				var offset =blogIndex;
				
				$.ajax({
					type:"get",
					url:"${path}/fetchBlogList",
					async:true,
					dataType:"json",
					data:{
						"offset":offset,
						"size":10
					},
					success:function(json){
						if(json.status=='1'){
							addAll(json.umessage);
						}else {
						    alert("加载失败");
						}
					}
				});
				
			}
			
			
			
			<%-- 初始化页面 --%>
			initialPage();
		</script>
</body>

</html>