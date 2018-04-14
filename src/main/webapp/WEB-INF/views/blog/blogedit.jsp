<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"/>


<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/vendor/bootstrap/css/bootstrap.min.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/css/blog-post.css"/>
		<link rel="stylesheet" type="text/css" href="${path}/blogStatic/vendor/editor/editormd.min.css"/>
		
		<title>Bran blog</title>
	</head>
	
	<body>
		<!-- Navigation -->
		
		<jsp:include page="bloginclude/blognav.jsp"/>
		
		<div class="container main-content">
			<br>
			<div class="input-group input-group-lg">
			  <span class="input-group-text " id="sizing-addon1">Title</span>
			  <input type="text" class="form-control" placeholder="Better late than never" aria-describedby="sizing-addon1" id="title"/>
			</div>
			<br>
			
			<div id="editormd">
			    <textarea style="display:none;">### Better late than never</textarea>
			</div>
			
			<div class="btn-group">
				<button class="btn btn-info" type="button" id="submitb">Submit</button>&nbsp;
				<button class="btn btn-info" type="button">Save</button>
			</div>
			
		</div>
		<br>
		<!-- Footer -->
		<jsp:include page="bloginclude/blogfoot.jsp"/>
		
		<script src="${path}/blogStatic/vendor/jquery/jquery.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/blogStatic/vendor/bootstrap/js/bootstrap.bundle.min.js" type="text/javascript" charset="utf-8"></script>
		<script src="${path}/blogStatic/vendor/editor/editormd.js" type="text/javascript" charset="utf-8"></script>
		<script type="text/javascript">
		    $(function() {
		        var editor = editormd("editormd", {
		            path : "./blogStatic/lib/",
		            width   : "100%",
                    height  : 560,
                    syncScrolling : "single"// Autoload modules mode, codemirror, marked... dependents libs path
		        });
		
		        /*
		        // or
		        var editor = editormd({
		            id   : "editormd",
		            path : "../lib/"
		        });
		        */
		    });
		    
		    function submitBlog(){
		    	var content=$(".editormd-markdown-textarea").attr("name","content").html();
		    	var title=$("#title").val();
		    	$.ajax({
		    		type:"post",
		    		url:"${path}/submitBlog",
		    		async:true,
		    		dataType:"json",
		    		data:{
		    			"title":title,
		    			"content":content
		    		},
		    		success:function(json){
						if(json.status=="1"){
							alert("success");
						}else{
							alert(json.message);
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
							
					}
		    	});
		    }
		    $("#submitb").click(function(){
		    	
				submitBlog();
		
			});
		</script>
	</body>
</html>