<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<% //remember id&pwd by cookie
	String username="";
	String password="";
	
	//receive cookies
	Cookie[] cookies=request.getCookies();
	if(cookies!=null){
		for(Cookie item:cookies){
			if(item.getName().equals("username")){
				username=item.getValue();
			}else if(item.getName().equals("password")){
				password=item.getValue();
			}
		}
	
	}
%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="include/commonfiles.jsp" flush="true"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>Branroom</title>
	</head>
	
	<body>
		<!-- header -->
		<%-- <%@ include file="include/header.jsp" %> --%>
		<jsp:include page="include/header.jsp" flush="true"/>
		
		<!--login area-->
			<div class="panel-body">
				<h3 align="center">Sign in to Bran's room</h3>
				<div class="container">
					<div class="row">
					  <div class="col-md-4 col-md-offset-4">
					  	<div class="panel panel-default">
						  <div class="panel-body">
						    <form>
							  <div class="form-group">
							    <label for="InputUser">Username</label>
							    <input type="text" class="form-control" id="InputUser" placeholder="Username" name="userid" value="<%=username %>"/>
							  </div>
							  <div class="form-group">
							    <label for="InputPassword">Password</label>
							   	&nbsp;	<a href="#">Forget password?</a>
							    <input type="password" class="form-control" id="InputPassword" placeholder="Password" name="pwd" value="<%=password %>"/>
							  </div>
							  <div class="checkbox">
							    <label>
							      <input type="checkbox" value="yes" name="isRemember" id="InputCheck"/>Remember me
							    </label>   
							  </div>
							    <br/>
							     <input type="button" class="btn btn-lg btn-success" id="signIn" value="Sign In"/>
							</form>
						  </div>
						</div>
						<br/>
						<div class="panel panel-default">
						  <div class="panel-body">
						    <a href="#">Create an account</a> or <a href="#">Visit as no one</a>
						  </div>
						</div>
					  </div>
					</div>
				</div>
			</div>
			
		
		<!--footer-->
			<jsp:include page="include/footer.jsp"/>
			
			<script type="text/javascript">
				function loginIn(){
					var userid=$("#InputUser").val();
					var pwd=$("#InputPassword").val();
					var isChecked=$("#InputCheck").is("checked")?"yes":"no";
					if(userid==""||pwd==""){
						return false;
					};
					$.ajax({
						type:"post",
						url:"${path}/signIn",
						async:true,
						dataType:"json",
						data:{
							"userid":userid,
							"pwd":pwd,
							"isRemember":isChecked
						},
						success:function(json){
							if(json.status=="1"){
								window.location.href="${path}/profile";
							}else{
								alert(json.message);
							}
						},
						error:function(XMLHttpRequest, textStatus, errorThrown){
							alert("fail to access!");
						}
					});
				};
				$("#signIn").on('click', function () {
				   var $btn = $(this).button('loading');
				    // business logic...
				   loginIn();
				   $btn.button('reset');
				});
			</script>
	</body>
</html>