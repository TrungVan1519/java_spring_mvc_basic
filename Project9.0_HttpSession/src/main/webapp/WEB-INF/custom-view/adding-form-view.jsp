<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<c:url value="/adding-form" var="url"/>

<h1>Adding Form </h1>
<form:form action="${url }" method="POST" modelAttribute="newProduct">
	
	<!-- Input -->
	<spring:message code="product.fullName.message"/>
	<form:input path="fullName"/> 
	<p style="color: red"><form:errors path="fullName"/></p>
	
	<spring:message code="product.cost.message"/>
	<form:input path="cost"/> 
	<p style="color: red"><form:errors path="cost"/></p>
	
	<button type="submit">Xác nhận</button>
</form:form>
