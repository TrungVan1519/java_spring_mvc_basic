<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding new student</title>
</head>
<body>
	<c:url value="/default-validation/adding-form" var="url"/>
	
	<h1>Form User</h1>
	<form:form action="${url }" method="POST" modelAttribute="newStudent">
	
		<!-- Hidden -->
 		<form:hidden path="id"/>
		
		<!-- Input -->
		Full name: <form:input path="fullName"/> 
		<p style="color: red"><form:errors path="fullName"/></p>
		
		Age: <form:input path="age"/> 
		<p style="color: red"><form:errors path="age"/></p>
		
		Email: <form:input path="email"/> 
		<p style="color: red"><form:errors path="email"/></p>
		
		Username: <form:input path="username"/> 
		<p style="color: red"><form:errors path="username"/></p>
		
		Password: <form:password path="password"/> 
		<p style="color: red"><form:errors path="password"/></p>
			
		<button type="submit">Xác nhận</button>
	</form:form>
</body>
</html>