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
			<div class="row">
				<div class="col-7">
					<div class="input-group input-group-lg">
					  <span class="input-group-text " id="sizing-addon1">Title</span>
					  <input type="text" class="form-control" placeholder="Better late than never"  value="${title}" aria-describedby="sizing-addon1" id="title"/>
					</div>
				</div>
				
				<div class="col-5">
					<div class="input-group input-group-prepend">
					  <span class="input-group-text " id="sizing-addon1">Keywords</span>
					  <input type="text" class="form-control" placeholder="以 , 分隔多个关键词" aria-describedby="sizing-addon1" value="${keywords}" id="keywords"/>
					</div>
				</div>
			</div>
			
			
			
			
			<br>
			
			<div id="editormd">
			    <textarea style="display:none;">${blogContent}</textarea>
			</div>
			
			<div class="btn-group">
				<button class="btn btn-info" type="button" id="submitb">Submit</button>&nbsp;
				<button class="btn btn-info disabled" type="button" id="saveb">Save</button>
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
		            path : "${path}/blogStatic/lib/",
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
		    	var keywords=$("#keywords").val();
		    	$.ajax({
		    		type:"post",
		    		url:"${path}/submitBlog",
		    		async:true,
		    		dataType:"json",
		    		data:{
		    			"title":title,
		    			"content":content,
		    			"keywords":keywords
		    		},
		    		success:function(json){
						if(json.status=="1"){
							alert("success");
							window.location.href="${path}/blogPersonal/${user.userId}";
						}else{
							alert(json.message);
						}
					},
					error:function(XMLHttpRequest, textStatus, errorThrown){
							
					}
		    	});
		    }
		    $("#submitb").click(function(){
		    	if($("#title").val() == ""){
		    	    alert("标题不能为空");
		    	    return false;
				}
				if($(".editormd-markdown-textarea").attr("name","content").html() == ""){
		    	    alert("内容不能为空");
		    	    return false;
				}
				if($())
				submitBlog();
		    	return true;
		
			});
		    
		    <c:if test="${not empty isUpdate}">
			    function updateBlog(){
			    	var content=$(".editormd-markdown-textarea").attr("name","content").html();
			    	var title=$("#title").val();
			    	var keywords=$("#keywords").val();
			    	$.ajax({
			    		type:"post",
			    		url:"${path}/updateBlog",
			    		async:true,
			    		dataType:"json",
			    		data:{
			    			"title":title,
			    			"content":content,
			    			"keywords":keywords,
			    			"blogid":${blogid}
			    		},
			    		success:function(json){
							if(json.status=="1"){
								alert("success");
								window.location.href="${path}/blogPersonal/${user.userId}";
							}else{
								alert(json.message);
							}
						},
						error:function(XMLHttpRequest, textStatus, errorThrown){
								
						}
			    	});
			    }
			    
			    $("#submitb").attr("class","btn btn-info disabled");
			    $("#saveb").attr("class","btn btn-info");
			    
			    $("#saveb").click(function(){
                    if($("#title").val() == ""){
                        alert("标题不能为空");
                        return false;
                    }
                    if($(".editormd-markdown-textarea").attr("name","content").html() == ""){
                        alert("内容不能为空");
                        return false;
                    }
			    	updateBlog();
                    return true;
			    });
		    </c:if>
		    
		   
		</script>
	</body>
</html>