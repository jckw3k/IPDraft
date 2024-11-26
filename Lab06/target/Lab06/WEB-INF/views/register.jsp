<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register page</title>
</head>

<body>
 <h2>Hello from Register. Message : ${message}</h2>
 	<h2>Register</h2>
	<form action="/register" method="post">
		<input type="hidden" name="action" value="register">
		Username: <input type="text" name="username" required><br>
		Password: <input type="password" name="password" required><br>
		<button type="submit">Register</button>
	</form>
	
	<!-- JSTL and EL to display the message it it exists  -->
	<c:if test="${not empty message}">
		<p  style="color:red">${message}</p>
	</c:if>
</body> 


</html>

