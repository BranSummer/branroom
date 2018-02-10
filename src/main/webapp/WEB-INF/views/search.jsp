<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="include/commonfiles.jsp"/>
		<title>branroom</title>
	</head>
	
	<body>
		<!-- header -->
		<jsp:include page="include/header.jsp"/>
	
		<!-- mid -->
		<div class="container panel-body main-content">
			<div class="row">
				<div class="col-md-1">
				</div>
				
				<div class="col-md-8">
					<ul class="nav nav-tabs">
					  <li role="presentation" class="active">
					  	<a href="#people" data-toggle="tab">People</a>
					  </li>
					  <li role="presentation">
					  	<a href="#article" data-toggle="tab">Articles</a>
					  </li>
					  <li role="presentation">
					  	<a href="#sources" data-toggle="tab">Sources</a>
					  </li>
					</ul>
					
					<div class="tab-content">
						<div class="tab-pane in active" id="people">
							<br/>
							<div class="panel">
								<ul class="list-group" id="peopleList">
									<jsp:include page="include/todo.jsp">
								</ul>
							</div>
						</div>
					</div>
					
					<div class="tab-pane " id="article">
						<jsp:include page="include/todo.jsp">
					</div>
					
					<div class="tab-pane " id="sources">
						<jsp:include page="include/todo.jsp">
					</div>
				</div>			 
			</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="include/footer.jsp"/>
	</body>
</html>