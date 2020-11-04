<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating product's info</title>
</head>
<body>
	<c:url value="/manual-form/updating-form/${productId}" var="url"/>

	<h3>Form thay đổi thông tin sản phẩm</h3>
	<form action="${url}" method="POST">
	
		<input type="hidden" name="id" value="${productId }">
		
		Tên sản phẩm: <input type="text" name="name"> <br>
		Giá sản phẩm: <input type="text" name="cost"> <br>
		
		<button type="submit">Sửa</button>
		
		<!-- 
			Vi khong su dung form;form nen phai su dung thu cong cai nay
			No co tac dung trong van de security
		 -->
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" /> 
	</form>
</body>
</html>

