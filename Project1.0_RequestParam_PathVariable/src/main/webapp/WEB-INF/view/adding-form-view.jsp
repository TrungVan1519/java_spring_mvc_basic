<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RequestParam Form View</title>
</head>
<body>
	<form action="product" method="post">
		<label for="inputName">Tên sản phẩm</label> 
		<input type="text" id="inputName" name="name"> 
		
		<label for="inputCost">Giá sản phẩm</label> 
		<input type="text" id="inputCost" name="cost"> 
		
		<button type="submit" class="btn btn-primary">Thêm</button>
	</form>
</body>
</html>

