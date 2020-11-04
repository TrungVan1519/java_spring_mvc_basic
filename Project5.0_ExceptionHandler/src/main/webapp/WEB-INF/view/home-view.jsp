<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Form</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
</head>
<body>
	<h3>Form nhập thông tin:</h3>

	<c:url value="/form" var="url" />
	<form:form action="${url }" modelAttribute="newStudent" method="GET">
	
		<div class="form-group">
			<label for="inputName">Tên</label> 
			<form:input type="text" path="name" class="form-control" id="inputName" />
			<small id="emailHelp" class="form-text text-muted">
				We'll never share your email with anyone else.
			</small>
		</div>
		
		<div class="form-group">
			<label for="inputAge">Tuổi</label> 
			<form:input type="number" path="age" class="form-control" id="inputAge" />
		</div>
		
		<div class="form-group">
			<label for="inputEmail">Email</label> 
			<form:input type="text" path="email" class="form-control" id="inputEmail" />
		</div>
		
		<button type="submit" class="btn btn-primary">Xác nhận</button>
	
	</form:form>

	<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
		integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
		integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
		integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
		crossorigin="anonymous"></script>
</body>
</html>