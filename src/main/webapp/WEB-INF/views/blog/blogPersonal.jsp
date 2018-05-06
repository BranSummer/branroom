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

<title>Bran Blog</title>

<!-- Bootstrap core CSS -->
<link href="${path}/blogStatic/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="${path}/blogStatic/css/blog-post.css" rel="stylesheet">
<title>Bran blog</title>
</head>

<body>
	<!-- Navigation -->
	<jsp:include page="bloginclude/blognav.jsp" />

	<!-- Page Content -->
	<div class="container main-content">

		<div class="row">

			<!-- Post Content Column -->
			<div class="col-lg-8">

				<h1 class="my-4">
					Bran <small>'s Blog</small>
				</h1>

				<!-- Blog Post -->
				<!--<div class="card mb-4">
						<img class="card-img-top" src="https://source.unsplash.com/random/750x150?文章" alt="Card image cap" height="150" />
						<div class="card-body">
							<h2 class="card-title">Post Title</h2>
							<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
							<a href="#" class="btn btn-primary">Read More</a>
						</div>
						<div class="card-footer text-muted">
							Posted on January 1, 2017 by
							<a href="#">Start Bootstrap</a>
						</div>
					</div>-->
				<div id="blog-palce"></div>


				<!-- Pagination -->
				<ul class="pagination justify-content-center mb-4" id="pageLink">
					<li class="page-item disabled" id="older">
						<button class="page-link" onclick="goToPrePage()">&larr;
							Prev</button>
					</li>
					<li class="page-item disabled" id="newer">
						<button class="page-link" onclick="goToNextPage()">Next
							&rarr;</button>
					</li>
				</ul>

			</div>

			<!-- Sidebar Widgets Column -->
			<div class="col-md-4">

				<!-- Search Widget -->
				<div class="card my-4">
					<h5 class="card-header">Search</h5>
					<div class="card-body">
						<div class="input-group">
							<input type="text" class="form-control"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-secondary" type="button">Go!</button>
							</span>
						</div>
					</div>
				</div>

				<!-- Categories Widget -->
				<!--<div class="card my-4">
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
					</div>-->

				<!-- Side Widget -->
				<div class="card my-4">
					<h5 class="card-header">Promotion</h5>
					<div class="card-body">
						This site was built on Aliyun Cloud Platform. <br />Click <a
							href="https://promotion.aliyun.com/ntms/act/ambassador/sharetouser.html?userCode=qwh4ptrk&utm_source=qwh4ptrk">here</a>
						for my promotion code
					</div>
				</div>

			</div>

		</div>
		<!-- /.row -->

	</div>
	<!-- /.container -->

	<!-- Footer -->
	<!-- Footer -->
	<jsp:include page="bloginclude/blogfoot.jsp" />

	<!-- Bootstrap core JavaScript -->
	<script src="${path}/blogStatic/vendor/jquery/jquery.min.js"></script>
	<script
		src="${path}/blogStatic/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="${path}/blogStatic/vendor/marked.min.js"
		type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
			function generateDate(d){
				var time=d.month+" "+d.dayOfMonth+","+d.year;
				return time;
			}
			
			function generateLink1(id){ 
				var src='${path}/blogPostPage/'+id;
				return src;
			}
			
			function generateLink2(author){
				var src='${path}/blogPersonal/'+author;
				return src;
			}
			
			function generateLink3(id){
				var src='${path}/blogUpdatePage/'+id;
				return src;
			}
			
			function addItem(m) {
				var card = $('<div></div>');
				card.addClass('card mb-4');
				var img = $('<img/>');
				img.addClass('card-img-top');
				img.attr('src','https://source.unsplash.com/random/750x150?文章');
				var cardbody = $('<div></div>');
				cardbody.addClass('card-body');
				var cardtitle = $('<h2></h2>');
				cardtitle.addClass('card-title');
				cardtitle.html(m.title);
				var cardtext = $('<p></p>');
				cardtext.addClass('card-text');
				cardtext.html(m.pretext);
				var link1 = $('<a></a>');
				link1.attr('href', generateLink1(m.id));
				link1.addClass('btn btn-primary');
				link1.html('Read More');
				cardbody.append(cardtitle);
				cardbody.append(cardtext);
				cardbody.append(link1);
				
				var cardfoot = $('<div></div>');
				cardfoot.addClass('card-footer text-muted');
				var meta = 'Posted on ' + generateDate(m.posttime) + ' by ';
				cardfoot.append(meta);
				var link2 = $('<a></a>');
				link2.attr('href',generateLink2(m.author) );
				link2.html(m.author);
				cardfoot.append(link2);
				
				var link3 = $('<a></a>');
				link3.attr('href', generateLink3(m.id));
				link3.addClass('btn btn-outline-info float-right');
				link3.html('edit');
				cardfoot.append(link3);
				
				card.append(img);
				card.append(cardbody);
				card.append(cardfoot);
				$("#blog-palce").append(card);
			}
			/*var test = {
				'title': 'test title',
				'pretext': 'Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? ',
				'l': '#',
				'date': 'January 1, 2017',
				'author': 'bran'
			}
			addItem(test);*/
			/*<div class="card mb-4">
				<img class="card-img-top" src="https://source.unsplash.com/random/750x150" alt="Card image cap" />
				<div class="card-body">
					<h2 class="card-title">Post Title</h2>
					<p class="card-text">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reiciendis aliquid atque, nulla? Quos cum ex quis soluta, a laboriosam.</p>
					<a href="#" class="btn btn-primary">Read More</a>
				</div>
				<div class="card-footer text-muted">
					Posted on January 1, 2017 by
					<a href="#">Start Bootstrap</a>
				</div>
			</div>*/
			function addAllItem(list){
				$.each(list, function(index,item) {
					addItem(item);
				});
			}
		</script>

	<script type="text/javascript">
			var itemCount=${count}; //符合查找条件的商品总页数，分页参考
			var pageIndex = 0; //当前页，默认为0
			var pageSize = 4; //每页显示个数		
			var pageNum=itemCount/pageSize+1;  //总页数
			var offset=pageSize*pageIndex;
			//按条件查找用户
			function searchItem(pageIndex, pageSize) {
				//清空要append的目的位置
				$("#blog-palce").empty();
				//判断跳页按钮可用性
				if(pageIndex<pageNum){
					$("#newer").attr("class","page-item");
				}else{
					$("#newer").attr("class","page-item disabled");
				}
				if(pageIndex>0){
					$("#older").attr("class","page-item");
				}else{
					$("#older").attr("class","page-item disabled");
				}
				//请求
				$.ajax({
					type:"post",
					url:"${path}/fetchBlogList/${author}",
					async:true,
					dataType:"json",
					data:{
						"offset":offset,
						"size":pageSize
					},
					success:function(json){
						if(json.status=='1'){
							addAllItem(json.umessage);
						}
					}
				});
				
			}

			//首页
			function goToFirstPage(){　　
				pageIndex = 0;　　
				searchItem(offset, pageSize);
			}

			//前一页
			function goToPrePage() {　　
				if(pageIndex>0){
					pageIndex=pageIndex-1;　　
					offset=pageIndex*pageSize;
					searchItem(offset, pageSize);
				}
			
			}

			//后一页
			function goToNextPage() {　　
				if(pageIndex<pageNum-1){
					pageIndex=pageIndex+1;
					offset=pageIndex*pageSize;
					searchItem(offset,pageSize)
				}
				
			}
			//尾页
			function goToEndPage() {　　
				pageIndex = itemCount - 1;　　
				searchItem(offset, pageSize);
			}
			
			
			goToFirstPage();
			
		</script>
</body>
</html>