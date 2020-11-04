<%@ page isELIgnored="false" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>


<div style="background: #E0E0E0; height: 55px; padding: 5px;">
  <div style="float: left">
     <h1>My Site</h1>
  </div>
  <div style="float: right; padding: 10px; text-align: right;">
     Search <input name="search">
  </div>
</div>


<!-- Check user login -->
<security:authorize access="isAuthenticated()">
	<!-- Display user name and role -->
	<h3>Account info</h3>
	<p>
		<security:authentication property="principal" var="authenticatedUser" />
		Username:${authenticatedUser.username }
		<br>
		<security:authentication property="principal" var="authenticatedUser" />
		Role(s): ${authenticatedUser.authorities }
	</p>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath }/login/logoutController" method="POST">
		<input type="submit" value="Logout account" />
	</form:form>
</security:authorize>

<!-- Show based on user roles -->
<security:authorize access="hasRole('COMMUNISM')">
	<h3 style="color: white; background: red;">Make our mother Rusia number one again</h3>
</security:authorize>

<security:authorize access="hasRole('CAPITALISM')">
	<h3 style="color: white; background: yellow;">Make more money</h3>
</security:authorize>

<security:authorize access="hasRole('IMPERIALISM')">
	<h3 style="color: white; background: blue;">Make America great again</h3>
</security:authorize>

<hr> <hr>

