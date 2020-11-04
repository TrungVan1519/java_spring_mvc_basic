<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h1>Shopping Cart:</h1>
<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Full name</th>
			<th scope="col">Cost</th>
			<th scope="col">Quantity</th>
			<th scope="col">Action</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${order.itemDTOs }" var="itemDTO">
			<tr>
				<th scope="row">${itemDTO.productDTO.id }</th>
				<td>${itemDTO.productDTO.fullName}</td>
				<td>${itemDTO.productDTO.cost }</td>
				<td>${itemDTO.numberOfChosenProduct }</td>
				<td>
					<c:url value="/order/adding-to-shopping-cart/${itemDTO.productDTO.id}" var="addingShoppingCartUrl"/>
					<c:url value="/order/decreasing-quantity/${itemDTO.productDTO.id }" var="decreasingShoppingCartUrl"/>
					<c:url value="/order/deleting-from-shopping-cart/${itemDTO.productDTO.id}" var="deletingShoppingCartUrl"/>
					
					<a href="${addingShoppingCartUrl }">Add To Shopping Cart</a> /
					<a href="${decreasingShoppingCartUrl }">Decrease Quantity</a> /
					<a href="${deletingShoppingCartUrl }">Delete From Shopping Cart</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
