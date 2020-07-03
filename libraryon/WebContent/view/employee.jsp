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
	<a href="createBook.jsp">
		<button>create book</button>
	</a>

	<table border=1>
		<tr>
			<th>title</th>
			<th>author</th>
			<th>editor</th>
			<th>quantity</th>
			<th>position</th>
		</tr>
		<c:forEach items="${bookList}" var="post">
			<tr>
				<td>${post.title}</td>
				<td>${post.author}</td>
				<td>${post.editor}</td>
				<td>${post.quantity}</td>
				<td>${post.position}</td>
				<td><form action="deleteBook.do"><input type="submit" value="delete"></form></td>
				<td><a href="createBook.jsp"><button>create book</button></a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>