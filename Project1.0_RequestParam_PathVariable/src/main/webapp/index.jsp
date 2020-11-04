<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

<c:url value="/request-param/form" var="requestParamUrl"/>
<c:url value="/path-variable/link" var="pathVariableUrl"/>

RequestParam Form:
<a href="${requestParamUrl }">Open RequestParam Form</a> <br>

PathVariable Link:
<a href="${pathVariableUrl }">Redirect to PathVariable Link</a>
