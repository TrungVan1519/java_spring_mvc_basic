<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating student's info</title>
</head>
<body>
	<c:url value="/spring-form-tag/updating-student" var="url"/>

	<h1>Form thay đổi thông sinh viên</h1>
	<form:form action="${url }" method="POST" modelAttribute="existingStudent">
	
		<!-- Hidden -->
		<form:hidden path="id"/><br>
		
		<!-- Input -->
		Tên tài khoản: <form:input path="username"/> 
		<p style="color: red"><form:errors path="username"/></p>
		
		Mật khẩu: <form:password path="password"/> 
		<p style="color: red"><form:errors path="password"/></p>
		<br>
			
		<!-- RadioButton -->
		Giới tính:
		<form:radiobutton path="gender" value="Male"/>Male
		<form:radiobutton path="gender" value="Female"/>Female
		<br>
			
		<!-- Dropdown -->
		Nới đến từ:
		<form:select path="country">
			<form:option value="Brazil">Brazil</form:option>
			<form:option value="France" label="France"/>
			<form:option value="England" label="England"/>
		</form:select> 
		<br>
		
		<!-- Checkbox -->
		Ngôn ngữ lập trình hướng tới:
		<form:checkbox path="programmingLanguage" value="Java"/>Java
		<form:checkbox path="programmingLanguage" value="CSharp"/>C#
		<form:checkbox path="programmingLanguage" value="Python"/>Python
		<form:checkbox path="programmingLanguage" value="Javascript"/>JS
		<br>
		
		<!-- TextArea -->
		Giới thiệu về bản thân: <br>
		<form:textarea path="about"/><br>
		<br>
		
		Đồng ý điều khoản này chứ?:
		<form:radiobutton path="acceptAgreement" value="true" label="Dong y dieu khoan nay"/>
		<br>
		
		<button type="submit">Xác nhận</button>
	</form:form>
</body>
</html>