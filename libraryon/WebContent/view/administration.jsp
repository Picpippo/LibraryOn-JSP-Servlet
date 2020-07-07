<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="change-pageCU.do">
		<input type="submit" value="create">
	</form>

	<table border=1>
		<tr>
			<th>name</th>
			<th>surname</th>
			<th>address</th>
			<th>email</th>
			<th>password</th>
		</tr>
		<c:forEach items="${userList}" var="user">
			<tr>
				<td>${user.name}</td>
				<td>${user.surname}</td>
				<td>${user.address}</td>
				<td>${user.email}</td>
				<td>${user.password}</td>
				<td><form action="delete-user.do">
				<input type="hidden" id="id_user" name="id_user" value="${user.id_user}">
				<input type="submit" value="delete"></form></td>
				<td><a href="createUser.jsp"><button>create user</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>