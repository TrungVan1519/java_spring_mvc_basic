<!-- <meta http-equiv="refresh" content="0; url=spring-form-tag/students" /> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

Spring Form Tags: <br>
<c:url value="/spring-form-tag/students" var="springFormTagUrl"/>
<a href="${springFormTagUrl }">Product list</a>


