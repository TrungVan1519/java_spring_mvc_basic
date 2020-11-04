<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Downloading File</title>
</head>
<body>
	<c:url value="/downloading-file/${uploadedImageName }" var="url"/>
	
	<h1>File was uploaded:</h1>
	<hr>
	
	<img alt="uploaded image" src="<c:url value="/server-source/${uploadedImageName }"/>"> <br>
	<a href="${url }">Download image</a> <br>
</body>
</html>