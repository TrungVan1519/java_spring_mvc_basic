<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>PathVariable Link View</title>
</head>
<body>
	<h3>Sử dụng @PathVariable nên không sử dụng được Form</h3>
	Link: 
	<a href="product/${defaultProduct.name }/${defaultProduct.cost }">
		Default Value
	</a>
</body>
</html>



