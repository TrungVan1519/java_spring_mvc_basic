<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Adding new product</title>
</head>
<body>
	<c:url value="/manual-form/adding-form" var="url"/>

	<h3>Form thêm mới sản phẩm</h3>
	<form action="${url}" method="POST">
	
		<input type="hidden" name="id" value="${productId }">
		
		Tên sản phẩm: <input type="text" name="name"> <br>
		Giá sản phẩm: <input type="text" name="cost"> <br>
		
		<button type="submit">Thêm</button>
		
		<!-- 
			Vi khong su dung the form;form nen phai su dung thu cong cai nay
			No co tac dung trong van de security
		 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	</form>
</body>
</html>

