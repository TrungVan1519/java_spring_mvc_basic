<!-- <meta http-equiv="refresh" content="0; url=spring-form-tag/students" /> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

Manual Form: <br>
<c:url value="/manual-form/products" var="manualFormUrl"/>
<a href="${manualFormUrl }">Product list</a> 


