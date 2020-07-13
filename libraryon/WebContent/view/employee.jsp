<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style>
.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	color: white;
	text-align: center;
}

body {
	text-align: center;
}

ul {
	text-align: center;
	list-style-type: none;
	margin: 0;
	padding: 14px;
	background-color: black;
}

li {
	color: white;
	font-family: verdana;
	font-size: 25px;
}

table {
	text-align: center;
}

.center {
	margin-left: auto;
	margin-right: auto;
}
</style>
</head>

<body bgcolor="whitesmoke">

	<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<table class="center">
		<tr>
			<td>
				<form method="post" action="change-pageCB.do">
					<input type="submit" value="Create book">
				</form> 
			</td>

			<td>
				<form method="post" action="change-pageLL.do">
					<input type="submit" value="Loan list">
				</form>
			</td>

			<td>
				<form method="post" action="back-home.do">
					<input type="submit" value="Exit">
				</form>
			</td>
		</tr>
	</table>
	<br>
	<table border=1 class="center">
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
					<form method="post" action="delete-book.do">
						<input type="hidden" id="id_book" name="id_book"
							value="${book.id_book}"> <input type="submit"
							value="Delete">
					</form>
				</td>

				<td>
					<form method="post" action="change-pageUB.do">
						<input type="hidden" id="id_book" name="id_book"
							value="${book.id_book}"> <input type="submit"
							value="Update">
					</form>
				</td>
				<td>


					<form method="post" action="change-pageLOAN.do">
						<input type="hidden" id="id_book" name="id_book"
							value="${book.id_book}">
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

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>

</body>
</html>