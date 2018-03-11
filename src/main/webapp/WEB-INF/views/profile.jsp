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
		<!--header-->
		<jsp:include page="include/header.jsp"/>
			
		<!-- mid -->
		<div class="container panel-body">
			<div class="row">
	
				<!-- sidebar -->
				<jsp:include page="include/sidebar.jsp"/>
				
				<!--profile area-->
				<div class="col-md-10">
					<div class="panel panel-default">
					  <div class="panel-body">
					    <h3>Your Profile</h3>
					    <hr/>
					    
					    <!--basic profile area-->
					   	<form class="form-horizontal profileForm">
					   		<div class="form-group">
					   			<label for="inputName" class="col-sm-2 control-label">Name</label>
					   			<div class="col-sm-10">
					   				<input class="form-control" type="text" name="userName" id="inputName" value="${user.userId}" readonly="readonly" />
					   			</div>
					   		</div>
					   		
					   		<div class="form-group">
							   <label for="inputEmail" class="col-sm-2 control-label">Email</label>
							   <div class="col-sm-10">
							    <input type="email" class="form-control" id="inputEmail" value="${user.email}" placeholder="example@Email.com">
							   </div>
							</div>
							
							
							  <div class="form-group">
							    <label for="inputText" class="col-sm-2 control-label">Introduction</label>
							    <div class="col-sm-10">
							      <textarea class="form-control" rows="3" id="inputText"  placeholder="say something ..">${user.introduction}</textarea>
							    </div>
							  </div>
							  <button type="submit" class="btn btn-success" id="updateInfor" data-loading-text="Loading..."  autocomplete="off">Update profile</button>						 
					   		<hr/>
					   	</form>
					   	
					   	<!--picture area-->
					   	<div class="profilePic">
					   		<h4>Profile Picture</h4>
					   		<img src="${user.avatar}" class="img-rounded" height="175" width="175"/>
					   		<br/><br/>
					   		<button type="button" class="btn btn-info" data-toggle="modal" data-target="#myModal">Choose a Avatar</button>
					   	</div>
					   	
					   	<!--password reset area-->
					   	<form class="form-horizontal profileForm"  method="post">
							  	<span id="helpBlock" class="help-block">Please ensure your password more than 6 characters</span>
							<div class="form-group">
							    <label for="inputPassword1" class="col-sm-2 control-label">Password</label>
							    <div class="col-sm-10">
							     <input type="password" class="form-control" id="inputPassword1" placeholder="Reset Your Password">
							    </div>
							  </div>
							  
							  <div class="form-group">
							    <label for="inputPassword2" class="col-sm-2 control-label">Password</label>
							    <div class="col-sm-10">
							      <input type="password" class="form-control" id="inputPassword2" placeholder="Input Password Again">
							    </div>
							  </div>
					   		<button type="submit" class="btn btn-primary" id="savePwd" data-loading-text="Loading..."  autocomplete="off">Save password</button>
					   	</form>
					   	
					  </div>
					</div>
				</div>
			</div>
		</div>
		
		<!--modal-->
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
			  <div class="modal-dialog" role="document">
			    <div class="modal-content">
			      <div class="modal-header">
			        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
			        <h4 class="modal-title" id="myModalLabel">Choose your avatar</h4>
			      </div>
			      <div class="modal-body">
			        <div class="row">
			        	
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar001.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar001.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar002.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar002.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar003.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar003.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar004.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar004.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar005.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar005.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar006.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar006.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/avatar007.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/avatar007.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	
			        	<div class="col-xs-6 col-md-3">
			        		<div class="thumbnail">
			        			<img src="${path}/static/img/thegirl.jpg" class="img-rounded"/>
				        		<div class="caption text-center">
				        			<input type="radio" id="avatars" value="${path}/static/img/thegirl.jpg" name="avatars"/>
				        		</div>
			        		</div>
			        	</div>
			        	
			        	
			        	
			        </div>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			        <button type="button" class="btn btn-primary" id="changeAvatar" data-loading-text="Loading..."  autocomplete="off">Save changes</button>
			      </div>
			    </div>
			  </div>
			</div>	
			
		<!-- footer -->
		<jsp:include page="include/footer.jsp"/>
	
		<!-- script -->
		<script type="text/javascript">
			function changeAvatar(){
				var avatar=$("input[name='avatars']:checked").val();
				$.ajax({
					type:"post",
					url:"${path}/${user.userId}/chageAvatar",
					async:false,
					dataType:"json",
					data:{"avatar":avatar},
					success:function(json){
						location.reload();
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert("fail to connect");
					}
					
				});
			};
			$('#changeAvatar').on('click', function () {
				   var $btn = $(this).button('loading');
				    // business logic...
				   changeAvatar();
				   $btn.button('reset');
			});
			function updateInfor(){
				var email=$('#inputEmail').val();
				var introd=$('#inputText').val();
				if(introd.length>254){
					alert("over introduction length limit");
					return false;
				}
				$.ajax({
					type:"post",
					url:"${path}/${user.userId}/updateInfo",
					async:false,
					dataType:"json",
					data:{
						"email":email,
						"introduction":introd
					},
					success:function(json){
						alert(json.message);
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert("fail to connect");
					}
				});
			};
			 $('#updateInfor').on('click', function () {
				   var $btn = $(this).button('loading');
				    // business logic...
				   updateInfor();
				   $btn.button('reset');
			});
			function pwdReset(){
				//judge whether the second pwd is the same as the first
				var pwd1=$('#inputPassword1').val();
				var pwd2=$('#inputPassword2').val();
				if(pwd1==""||pwd2==""||pwd1!=pwd2){
					alert('invalid input!!');
					return false;
				}
				if(pwd1.length<6||pwd1.length>50){
					alert('over password length limit ! ');
					return false;
				}
				
				$.ajax({
					type:"post",
					url:"${path}/${user.userId}/resetPwd",
					async:false,
					dataType:"json",
					data:{"password":pwd1},
					success:function(json){
						
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
						alert("fail to connect");
					}
				});
				return true;
			}
			 $('#savePwd').on('click', function () {
				   var $btn = $(this).button('loading');
				    // business logic...
				   pwdReset();
				   $btn.button('reset');
			});
		</script>
		
	</body>
</html>