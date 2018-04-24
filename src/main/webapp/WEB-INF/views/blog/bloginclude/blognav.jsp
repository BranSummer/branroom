<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
	<div class="container">
		<a class="navbar-brand" href="${path}/blogHome">Bran Blog</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarResponsive" aria-controls="navbarResponsive"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarResponsive">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item active">
					<a class="nav-link" href="${path}/profile">主页<span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link"href="${path }/blogEdit">写文章</a></li>
				<c:if test="${not empty user}" >
					<li class="nav-item"><a class="nav-link"href="${path}/blogPersonal/${user.userId}">我的主页</a></li>
				</c:if>
				
				<c:if test="${empty user}" >
					<li class="nav-item"><a class="nav-link"href="${path}/login">我的主页</a></li>
				</c:if>
				<li class="nav-item"><a class="nav-link" href="${path}/searchPage">发现</a></li>
			</ul>
		</div>
	</div>
</nav>