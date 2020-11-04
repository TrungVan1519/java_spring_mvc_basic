<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head>

<!-- Cach 1: Su dung the c:url> -->
<c:url value="/static-source/image/favicon/favicon.ico" var="faviconUrl"/>
<c:url value="/static-source/css/style.css" var="customCssUrl"/>

<link rel="shortcut icon" href="${faviconUrl }">
<link rel="stylesheet" type="text/css" href="${customCssUrl }" >

<!-- Cach 2: Su dung contextPath -->
<!-- <link rel="shortcut icon" href="${pageContext.request.contextPath }/static-source/image/favicon/favicon.ico"> -->

</head>

<body>

<h3 class="blackGround"> Đây là project vd về sử dụng tài nguyên tĩnh có sẵn trong project </h3>

<c:url value="/static-source/image/angel.jpg" var="imageUrl"/>
<img src="${imageUrl }" alt="Responsive image" style="width: 500px; height: 600px;">

</body>

</html>
