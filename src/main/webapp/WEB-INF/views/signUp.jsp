<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="include/commonfiles.jsp" flush="true"/>
		<link rel="stylesheet" type="text/css" href="${path}/static/css/login.css"/>
		<title>Insert title here</title>
	</head> 
	
	<body>
	
		<!-- header -->
		<%-- <%@ include file="include/header.jsp" %> --%>
		<jsp:include page="include/header.jsp" flush="true"/>
		
		<!--sign up area-->
		<div class="panel-body main-content">
			<div class="container">
				<div class="row">
				  <div class="col-md-6 col-md-offset-1">
				  	<div class="jumbotron">
				  		<h1>Welcome to Branroom</h1>
				  		<p>
				  			Here is my small site just for fun ;You can chat with other people online or post your own blogs here .
				  
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
							<div class="alert alert-warning alert-hide" id="userfail" role="alert">
							    this id has been occupied <strong>:-(</strong>
							</div>
						  </div>
						  
						  <div class="form-group">
						    <label for="InputEmail">Email</label>
						    <input type="text" class="form-control" id="InputEmail" placeholder="you@example.com">
						  	<div class="alert alert-warning alert-hide" id="emailfail" role="alert">
							    Incorrect mail format<strong>:-(</strong>
							</div>
						  </div>
						  
						  <div class="form-group">
						    <label for="InputPassword">Password</label> (at least 6 characters)
						    <input type="password" class="form-control" id="InputPassword" placeholder="create a password">
						  	<div class="alert alert-warning alert-hide" id="pwdfail" role="alert">
							    Incorrect password format<strong>:-(</strong>
							</div>
						  </div>
						  
						    <br/>
						  <a id="button" class="btn btn-lg btn-success fullwidth" role="button">Sign up</a>
						 
						</form>
					  </div>
					</div>
					<br/>
					<div class="panel panel-default">
					  <div class="panel-body">
					    <a href="${path}/login">Sign in</a> or <a href="${path}/blogHome">Visit Blog</a>
					  </div>
					</div>
				  </div>
				</div>
			</div>
		</div>
		
		<!--footer-->
			<jsp:include page="include/footer.jsp"/>
		
		<script type="text/javascript">
		var idTag=false;
		var emailTag=false;
		var pwdTag=false;
		
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
							$('#userfail').hide();
							idTag=true;
							
						}else{
							$('#userfail').show();
							idTag=false;
						}
					},
					error:function(json){
						alert('error')
					}
				});
		}
		
		$('#InputEmail').blur(function(){
			checkEmail();
		})
		function checkEmail(){
			var emailText=$('#InputEmail').val();
			if (isEmail(emailText)) {
				emailTag=true;
				$('#emailfail').hide();
			} else{
				emailTag=false;
				$('#emailfail').show();
			}
		}
		function isEmail(str){ 
			var reg = /^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(.[a-zA-Z0-9_-])+/; 
			return reg.test(str); 
		}
		
		$("#InputPassword").bind('input propertychange',function(){
			checkPwd();
		})
		
		function checkPwd(){
			pwdText=$('#InputPassword').val();
			if(pwdText.length<6||pwdText.length>255){
				pwdTag=false;
				$('#pwdfail').show();
			}else{
				pwdTag=true;
				$('#pwdfail').hide();
			}
		}
		
		$('#button').click(function(){
			submit();
		})
		
		function submit(){
			var userid=$("#InputUser").val();
			var pwd=$("#InputPassword").val();
			var email=$("#InputEmail").val();
			if(userid==''||pwd==''||email==''){
				return false;
			}
			if(!idTag||!emailTag||!pwdTag){
				return false;
			}
			$.ajax({
					type:"post",
					url:"${path}/signUp",
					async:true,
					data:{
						"userid":userid,
						"pwd":pwd,
						"email":email
					},
					dataType:"json",
					success:function(json){
						if(json.status=='1'){
							window.location.href="${path}/profile";
						}
					},
					error:function(json){
						alert('error');
					}
				});
		}
		
		
		
		 
	</script>
	</body>
</html>