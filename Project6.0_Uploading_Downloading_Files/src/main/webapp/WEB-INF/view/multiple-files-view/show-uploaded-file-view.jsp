<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Downloading multiple files</title>
</head>
<body>
	<h1>File was uploaded:</h1>
	<div class="container-fluid">
		<div class="row">
			<c:forEach items="${imageNames }" var="uploadedImageName">
			
				<c:url value="/downloading-file/${uploadedImageName }" var="url"></c:url>
				
				<div class="col-md-12">
					<img alt="uploaded image" src="<c:url value="/server-source/${uploadedImageName }"/>"> <br>
					<a href="${url }">Download image</a> <br>
				</div>
			</c:forEach>
		</div>
	</div>
	
</body>
</html>