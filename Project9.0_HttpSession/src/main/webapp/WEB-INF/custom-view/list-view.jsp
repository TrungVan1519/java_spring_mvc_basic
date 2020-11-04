<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<c:url value="/adding-form" var="url"/>

<h1>Product list</h1>
<a href="${url }">Add new product</a> <br>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Full name</th>
			<th scope="col">Cost</th>
			<th scope="col">Action</th>
			<th scope="col">Shopping Cart</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${products }" var="product">
			<tr>
				<th scope="row">${product.id }</th>
				<td>${product.fullName}</td>
				<td>${product.cost }</td>
				<td>
					<c:url value="/products/${product.id}" var="moreUrl"/>
					<c:url value="/updating-form/${product.id }" var="updatingUrl"/>
					<c:url value="/deleting-product/${product.id}" var="deletingUrl"/>
					
					<a href="${moreUrl }">More</a> /
					<a href="${updatingUrl }">Update</a> /
					<a href="${deletingUrl }">Delete</a>
				</td>
				<td>
					<c:url value="/order/adding-to-shopping-cart/${product.id}" var="addingShoppingCartUrl"/>
					<a href="${addingShoppingCartUrl }">Add To Shopping Cart</a>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
