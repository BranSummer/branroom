<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<div class="container-fluid panel-heading header">
	<div class="col-md-8">
		<span style="font-size: xx-large">
			Bran's room
		</span>
	</div>
	<div class="col-md-4">
		<c:if test="${not empty user}">
			<img src="${user.avatar}" alt="..." class="img-circle" height="50"width="50" />
		</c:if>
		<c:if test="${empty user}">
			<img src="${path}/static/img/default.png" alt="..." class="img-circle" height="50"width="50" />
		</c:if>
		
		<div class="btn-group ">
		  <button type="button" class="btn btn-lg dropdown-toggle header" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		   <span class="glyphicon glyphicon-th-list" aria-hidden="true"></span>
		   <span class="caret" ></span>
		  </button>
		  <ul class="dropdown-menu">
		    <li><a href="#">Chat room</a></li>
		    <li><a href="#">Your profile</a></li>
		    <li><a href="#">Blog</a></li>
		    <li><a href="#">Sign out</a></li>
		  </ul>
		</div>
	</div>	
</div> 