<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="col-md-2">
	<button id="showLf" style="width: 100%;" class="btn btn-group">
		<span class="glyphicon glyphicon-chevron-down" aria-hidden="true"></span>
	</button>
	<div class="list-group" id="leftBtns">
		<button type="button" class="list-group-item" aria-label="Left Align" id="chatroom">
			<span class="glyphicon glyphicon-send" aria-hidden="true"></span> Chat Room 
		</button>
		<button type="button" class="list-group-item" aria-label="Left Align" id="profile">
			<span class="glyphicon glyphicon-align-justify" aria-hidden="true"></span> Your Profile
		</button>
		<button type="button" class="list-group-item" aria-label="Left Align" id="blog">
			<span class="glyphicon glyphicon-home" aria-hidden="true"></span> Blog
		</button>
		<button type="button" class="list-group-item" aria-label="Left Align" id="help">
			<span class="glyphicon glyphicon-book" aria-hidden="true"></span> Help
		</button>
		<button type="button" class="list-group-item" aria-label="Left Align" id="signout">
			<span class="" aria-hidden="true"></span>Sign Out
		</button>
	</div>
</div>
<script type="text/javascript">
	$("#showLf").click(function(){
		$("#leftBtns").toggle();
	});
	$("#chatroom").click(function(){
		window.location.href='#';
	});
	$("#profile").click(function(){
		window.location.href='#';
	});
	$("#signout").click(function(){
		window.location.href='#';
	});
	$("#blog").click(function(){
		window.location.herf='#';
	})	
</script>