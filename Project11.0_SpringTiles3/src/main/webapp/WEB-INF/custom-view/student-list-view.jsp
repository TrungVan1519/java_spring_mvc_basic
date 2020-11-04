<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url value="/default-validation/adding-form" var="url"/>

<h1>Student list</h1>
<a href="${url }">Add new student</a> <br>

<table class="table">
	<thead class="thead-dark">
		<tr>
			<th scope="col">#</th>
			<th scope="col">Fullname</th>
			<th scope="col">Age</th>
			<th scope="col">Email</th>
			<th scope="col">Username</th>
			<th scope="col">Password</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${students }" var="student">
			<tr>
				<th scope="row">${students.indexOf(student) }</th>
				<td>${student.fullName}</td>
				<td>${student.age }</td>
				<th>${student.email }</th>
				<td>${student.username }</td>
				<td>${student.password }</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
