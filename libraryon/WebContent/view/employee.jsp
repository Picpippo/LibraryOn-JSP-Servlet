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
		<input type="submit" value="Create book">
	</form>
	<br>
	<form action="change-pageLL.do">
		<input type="submit" value="Loan list">
	</form>
	<br>
	<br>
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
				<td>
				<form action="delete-book.do">
					<input type="hidden" id="id_book" name="id_book" value="${book.id_book}">
					<input type="submit" value="Delete">
				</form>
				</td>
				
				<td>
				<form action="change-pageUB.do">
					<input type="hidden" id="id_book" name="id_book" value="${book.id_book}">
					<input type="submit" value="Update">
				</form>
				</td>
				<td>
				
				
				<form action="change-pageLOAN.do">
					<input type="hidden" id="id_book" name="id_book" value="${book.id_book}">
					<c:if test="${book.quantity > 0}">
					<input type="submit" value="Loan">
					</c:if>
					<c:if test="${book.quantity <= 0}">				
					<input type="submit" value="Loan" disabled>
					</c:if>
				</form>
				
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>
	<form action="back-home.do">
		<input type="submit" value="Home">
	</form>
</body>
</html>