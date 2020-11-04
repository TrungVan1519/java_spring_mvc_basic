<!-- <meta http-equiv="refresh" content="0; url=spring-form-tag/students" /> -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false" %>

Upload single file: <br>
<c:url value="/single-file/uploading" var="uploadSingleFile"/>
<a href="${uploadSingleFile }">Upload single file</a> <br>

<hr>
Upload multiple files: <br>
<c:url value="/multiple-files/uploading" var="uploadMultipleFile"/>
<a href="${uploadMultipleFile }">Upload multiple file</a> <br>

						
						