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
	<a href="createUser.jsp">
		<button>create user</button>
	</a>

	<table border=1>
		<tr>
			<th>name</th>
			<th>surname</th>
			<th>address</th>
			<th>email</th>
			<th>password</th>
		</tr>
		<c:forEach items="${userList}" var="post">
			<tr>
				<td>${post.name}</td>
				<td>${post.surname}</td>
				<td>${post.address}</td>
				<td>${post.email}</td>
				<td>${post.password}</td>
				<td><form action="deleteUser.do"><input type="submit" value="delete"></form></td>
				<td><a href="createUser.jsp"><button>create user</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>