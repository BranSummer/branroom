<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="path" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<jsp:include page="include/commonfiles.jsp"/>
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" rel="stylesheet">
		<link rel="stylesheet" href="${path}/static/css/emoji.css" />
		<title>Branroom</title>
	</head>

	<body>
		
		<!-- header -->
		<jsp:include page="include/header.jsp"/>
		
		<!--mid div-->
		<div class="container panel-body" >
			<div class="row">
			
				<!-- sidebar -->
				<jsp:include page="include/sidebar.jsp"/>
				
				<!--chat div-->
				<div class="col-md-7">
					<div class="panel panel-default">
					  <div class="panel-heading">...</div>
					  <div class="panel-body">
					   	<div class="mychat-div" id="chat_scroll">
						<div class="chat" id="chat">
							<!-- set message here -->
						</div>
					</div>	
					  </div>
					</div>
					
					<!--textarea div-->
					<div class="input-group" style="height: 250; width: 100%;">
						<textarea name="input_area" id="input_area" placeholder="input here……" data-emojiable="true" data-emoji-input="unicode" style="height: 200 ;width: 100%;resize: none;"  ></textarea>
					</div>
					<div>
						<button type="button" class="btn btn-primary" id="conBtn" data-loading-text="Loading..."  autocomplete="off">
							<span class="glyphicon glyphicon-link" aria-hidden="true"></span> <span id="conLabel">connect</span>
						</button>
						<button type="button" class="btn btn-primary" id="disconBtn" data-loading-text="Loading..."  autocomplete="off">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span> <span id="conLabel">disconnect</span>
						</button>
						<button type="button" class="pull-right" onclick="send()">
							<span class="glyphicon glyphicon-send" aria-hidden="true"></span> send
						</button>
					</div>		
				</div>
				<div class="col-md-3">
					<div class="panel panel-default">
					  <div class="panel-heading">
					    <h3 class="panel-title">
					    	<span class="glyphicon glyphicon-user" aria-hidden="true"></span> Online List 
	 							<br>
	 							<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
					    </h3>
					  </div>
					  <div class="panel-body onlineList" id="onlineList">
					  	<!-- onlinelist location -->
					  </div>
					</div>
				</div>
			</div>
		</div>
		
		<!-- footer -->
		<jsp:include page="include/footer.jsp"/>
		
		
		<!--begin emoji-picker js-->
		<script src="${path}/static/js/config.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/js/emoji-picker.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/js/jquery.emojiarea.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/static/js/util.js" type="text/javascript" charset="utf-8"></script>
		
		<script type="text/javascript">
			$(function(){
				window.emojiPicker = new EmojiPicker({
				  emojiable_selector: '[data-emojiable=true]',
				  assetsPath: '${path}/static/img',
				  popupButtonClasses: 'fa fa-smile-o'
				});
				
				window.emojiPicker.discover();
			})
		</script>
		<!--end emoji-picker js-->
		
		<!-- js -->
			<script type="text/javascript">
			var websocket=null;
			var ws="ws://"+location.host+"/branroom/server/${user.userId}";
			establishConn();
			//send message
			function send(){
				var message=$("#input_area").val();
				var messagePack=JSON.stringify(
					{
						"type":"TYPE_USER_CHAT",  
						"userid":'${sessionScope.user.userId}',
						"avatar":'${user.avatar}',
						"content":message   
					//  "list":list,	
					}		
				);
				if(message!=""&&message!=null)
					websocket.send(messagePack);
				
			}
			//close websockete when window closed
			window.onbeforeunload=function(){
				websocket.close();
			}
			
			
			//Solve the message from server
			function parseMessage(message){
				var m=JSON.parse(message);
				if(m.type=="TYPE_USER_CHAT"){
					setUserMessage(m);
				}else if(m.type=="TYPE_SERVER"){
					setSysMessage(m);
				}
			}
			
			//display client sysmessage on page
			function setMessageInnerHTML(message){
				var chatDiv=document.getElementById("chat_scroll");
				document.getElementById("chat").innerHTML+="<div class='notice-div'><span class='glyphicon glyphicon-bell'></span>"+message+"</div>";
				chatDiv.scrollTop=chatDiv.scrollHeight;
			}
			
			//show onlineList and server message 
			function setSysMessage(anaMessage){
				var list=anaMessage.onlineList;
				$("#onlineList").html("");
				$.each(list, function(index, item){
					var userItem=
						"<div class=\"btn-group \">"
					  		+"<button type=\"button\" class=\"btn btn-default onlineUser\" >"
					  		+"<img src=\""+item.avatar+"\" alt=\"...\" class=\"img-rounded\" height=\"40\"width=\"40\" align=\"left\"/>"
							+"<span>"
								+item.userId
							+"</span>"
				  		+"</div>"
					$("#onlineList").append(userItem);
				});
				
			}
			
			//display user message on page 
			function setUserMessage(anaMessage){
				var user=anaMessage.userid;
				var contents=anaMessage.content;
				var avatar=anaMessage.avatar;
				var chatDiv=document.getElementById("chat_scroll");
				if(user=='${sessionScope.user.userId}'){
					document.getElementById("chat").innerHTML+="<div class='eachline'><img src='${user.avatar}' class='img-rounded image_me' height='40' width='40'/><div class='bubble me'>"+contents+"</div></div>";
				}else
					document.getElementById("chat").innerHTML+="<div class='eachline'><img src='"+avatar+"' class='img-rounded image_you' height='40' width='40'/><div class='bubble you'>"+contents+"</div></div>";
				chatDiv.scrollTop=chatDiv.scrollHeight;
				$("#input_area").val("");
			}
			//close websocket
			function closeWebSocket(){
				if(websocket!=null){
					websocket.close();
					websocket=null;
					$("#onlineList").html("");
				}else alert("already disconnected!");
			}
			
			 $('#conBtn').on('click', function () {
			    var $btn = $(this).button('loading')
			    establishConn();
			    $btn.button('reset')
			 });
			  $('#disconBtn').on('click', function () {
			    var $btn = $(this).button('loading')
			    closeWebSocket();
			    $btn.button('reset')
			 });
			 function establishConn(){
				 if(websocket==null){
					//judge whether support websocket
						if("websocket" in window){
							websocket=new WebSocket(ws);
						}else 
							alert("Not Support websocket");
						//callback on establish connection
						websocket.onopen=function(){
							setMessageInnerHTML("connected ..");
							sendUserInfo();
						};
						//callback on error
						websocket.onerror=function(){
							setMessageInnerHTML("error ! !");
						};
						//callback on webSocket close
						websocket.onclose=function(){
							setMessageInnerHTML("websocket closed !");
						};
						//callback when receive message
						websocket.onmessage=function(event){
							parseMessage(event.data);
						};
				 }else{
					 alert("connection exists!")
				 }
			 }
			 
			 function sendUserInfo(){
				 var userInfo=JSON.stringify(
						 {
							"type":"TYPE_USER_INFO",  // TYPE_USER_INFO
							"userid":'${sessionScope.user.userId}',
							"avatar":'${sessionScope.user.avatar}',
							"content":''  //can add other information
						 }
				 );
				 websocket.send(userInfo);
			 }
		</script>
	</body>
</html>