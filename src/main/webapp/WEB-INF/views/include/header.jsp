<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!--<div class="container-fluid panel-heading header">
	<div class="col-md-8">
		<span style="font-size: xx-large">
			Bran's room
		</span>
	</div>
	<div class="col-md-4">
		<c:if test="${not empty user}">
			<img src="${user.avatar}" alt="..." class="img-circle" height="50"width="50" />
			<div class="btn-group ">
		  <button type="button" class="btn btn-lg dropdown-toggle header" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		   <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
		   <span class="caret" ></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="${path}/chat">Chat room</a></li>
		    <li><a href="${path}/profile">Your profile</a></li>
		    <li><a href="#">Blog</a></li>
		    <li><a href="${path}/signOut">Sign out</a></li>
		  </ul>
		</div>
			
		</c:if>
		<c:if test="${empty user}">
			<img src="${path}/static/img/default.png" alt="..." class="img-circle" height="50"width="50" />
		</c:if>
		
		
	</div>	
</div> -->
	
<header>
	<nav class="navbar navbar-default navbar-inverse panel-heading">
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-8">
					<!-- Logo -->
					<div class="navbar-header">
				        <img alt="Brand" src="${path}/static/img/logo.png" height="55px"/>
					</div>
					<form class="navbar-form navbar-left from-inline" role="search">
						<div class="form-group pull-left">
						    <input type="text" class="form-control" placeholder="Search">
						</div>
						<button type="submit" class="btn btn-default"><span class="glyphicon glyphicon-search"></span></button>
					</form>
				</div>
				
				<div class="col-md-4">
					<c:if test="${not empty user}">
						<ul class="nav navbar-nav navbar-left">
							<li>
								<img src="${user.avatar}" alt="..." class="img-circle" height="50"width="50" />
							</li>
							
							<li class="dropdown">
						        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"> 
						        	<span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
						        	<span class="caret"></span>
						        </a>
						        <ul class="dropdown-menu">
						        	<li><a href="${path}/chat">Chat room</a></li>
						            <li><a href="${path}/profile">Your profile</a></li>
						            <li><a href="#">Something else here</a></li>
						            <li role="separator" class="divider"></li>
						            <li><a href="${path}/signOut">Sign out</a></li>
						        </ul>
						    </li>
						</ul>
					</c:if>
					<c:if test="${empty user}">
						<img src="${path}/static/img/default.png" alt="..." class="img-circle" height="50"width="50" />
					</c:if>
					
				</div>
			</div>
		</div>
	</nav>
</header>