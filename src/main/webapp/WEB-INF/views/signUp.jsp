<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="include/commonfiles.jsp" flush="true"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link rel="stylesheet" type="text/css" href="${path}/static/css/login.css"/>
		<title>Insert title here</title>
	</head>
	
	<body>
	
		<!-- header -->
		<%-- <%@ include file="include/header.jsp" %> --%>
		<jsp:include page="include/header.jsp" flush="true"/>
		
		<!--sign up area-->
		<div class="panel-body">
			<div class="container">
				<div class="row">
				  <div class="col-md-6 col-md-offset-1">
				  	<div class="jumbotron">
				  		<h1>hello world</h1>
				  		<p>
				  			GitHub is a development platform inspired by the way you work. 
				  			From open source to business, you can host and review code, manage projects, 
				  			and build software alongside millions of other developers. 
				  		</p>
				  	</div>
				  </div>
				  
				  <div class="col-md-4">
				  	<div class="panel panel-default">
					  <div class="panel-body">
					    <form>
						  <div class="form-group">
						    <label for="InputUser">Username</label>
						    <input type="text" class="form-control" id="InputUser" placeholder="pick a username">
							<div class="alert alert-warning alert-hide" id="fail" role="alert">
							    this id has been occupied <strong>:-(</strong>
							</div>
						 
						  </div>
						  <div class="form-group">
						    <label for="InputEmail">Email</label>
						    <input type="text" class="form-control" id="InputEmail" placeholder="you@example.com">
						  </div>
						  <div class="form-group">
						    <label for="InputPassword">Password</label>
						    <input type="password" class="form-control" id="InputPassword" placeholder="create a password">
						  </div>
						  
						    <br/>
						  <a tabindex="0" id="button" class="btn btn-lg btn-success fullwidth" role="button" data-toggle="popover" data-trigger="focus" title="Message from server" data-content="Wrong password or non-existent account">Sign up</a>
						 
						</form>
					  </div>
					</div>
					<br/>
					<div class="panel panel-default">
					  <div class="panel-body">
					    <a href="${path}/login">Sign in</a> or <a href="#">Visit as no one</a>
					  </div>
					</div>
				  </div>
				</div>
			</div>
		</div>
		
		<!--footer-->
			<jsp:include page="include/footer.jsp"/>
		
		<script type="text/javascript">
		var isUseable=false
		$('#InputUser').blur(function(){
			checkUserId();
		})
		function checkUserId(){
			var userid=$('#InputUser').val()
			if(userid==''){
				return false;
			}
			$.ajax({
					type:"post",
					url:"${path}/check",
					async:true,
					data:{"userid":userid},
					dataType:"json",
					success:function(json){
						if(json.status=='1'){
							$('#fail').hide();
						}else{
							$('#fail').show();
						}
					},
					error:function(json){
						alert('error')
					}
				});
		}
		
		
		
		function submit(){
			var userid=$("#InputUser").val();
			var pwd=$("#InputPassword").val();
			var email=$("#InputEmail").val();
			if(userid==''||pwd==''||email==''){
				return false
			}
			$.ajax({
					type:"post",
					url:"#",
					async:true,
					data:{
						"userid":userid,
						"pwd":pwd,
						"email":email
					},
					dataType:"json",
					success:function(json){
						if(json.status=='1'){
							window.location.href="${path}/signUp";
						}else{
							alert(json.message);
						}
					},
					error:function(json){
						alert('error');
					}
				});
		}
		
		function checkEmail(str){ 
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
			return reg.test(str); 
		} 
	</script>
	</body>
</html>