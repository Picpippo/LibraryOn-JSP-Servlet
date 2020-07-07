<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body bgcolor="whitesmoke">
	<form action="change-pageCB.do">
		<input type="submit" value="crea">
	</form>
	<br>
	<br>
	<form action="refresh.do">
		<input type="submit" value="refresh">
	</form>
	<table border=1>
		<tr>
			<th>title</th>
			<th>author</th>
			<th>editor</th>
			<th>quantity</th>
			<th>position</th>
		</tr>
		<c:forEach items="${bookList}" var="book">
			<tr>
				<td>${book.title}</td>
				<td>${book.author}</td>
				<td>${book.editor}</td>
				<td>${book.quantity}</td>
				<td>${book.position}</td>
				<td><form action="deleteBook.do">
						<input type="submit" value="delete">
					</form></td>
				<td><a href="updateBook.jsp"><button>Update book</button></a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>