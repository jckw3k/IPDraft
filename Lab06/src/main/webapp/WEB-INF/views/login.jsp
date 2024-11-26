<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login</h2>
	<form action="/Lab06/login" method="post">
		<input type="hidden" name="action" value="login">
		Username: <input type="text" name="username" ><br>
		Password: <input type="password" name="password" ><br>
		<button type="submit">Login</button>
	</form>
	
	<!-- JSTL and EL to display the message it it exists  -->
	<c:if test="${not empty message}">
		<p  style="color:red">${message}</p>
	</c:if>

</body>
</html>