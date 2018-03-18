<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}" />

<header>
	<nav class="navbar navbar-default navbar-inverse navbar-fixed-top">
		<div class="container ">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
			        <span class="sr-only">Toggle navigation</span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			        <span class="icon-bar"></span>
			      </button>
				<a class="navbar-brand" href="#">Home</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav">
					<li>
						<a href="${path}/chat">Chat</a>
					</li>
					<li>
						<a href="${path}/blogEdit">Blog</a>
					</li>

				</ul>
				<form class="navbar-form navbar-left">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
				<c:if test="${not empty user}" >
					<ul class="nav navbar-nav navbar-right">
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
								<img class="img-rounded nav-avatar" src="${user.avatar}" height="30px" width="30px"/>
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li>
									<a href="${path}/profile">Your profile</a>
								</li>
								<li>
									<a href="#">Something else here</a>
								</li>
								<li role="separator" class="divider"></li>
								<li>
									<a href="${path}/signOut">Sign out</a>
								</li>
							</ul>
						</li>
					</ul>
				</c:if>	
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</header>