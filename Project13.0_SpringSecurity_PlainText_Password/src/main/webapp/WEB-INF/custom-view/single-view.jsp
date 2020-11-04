<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<h1>Product info:</h1>
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Full name</th>
			<th scope="col">Cost</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<th scope="row">${selectedProduct.id}</th>
			<td>${selectedProduct.fullName}</td>
			<td>${selectedProduct.cost}</td>
		</tr>
	</tbody>
</table>
