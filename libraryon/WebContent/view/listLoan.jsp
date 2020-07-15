<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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
<title>Loan list</title>

</head>
<body bgcolor="whitesmoke">
	<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<br>
	<table border=1 class="center">
		<tr>
			<th>id_book</th>
			<th>id_user</th>
			<th>assignment_date</th>
			<th>expiration_date</th>
			<th>state</th>
		</tr>
		<c:forEach items="${loanList}" var="loan">
			<tr>
				<td>${loan.id_book}</td>
				<td>${loan.id_user}</td>
				<td>${loan.assignment_date}</td>
				<td>${loan.expiration_date}</td>
				<td>${loan.state}</td>
				<td>
					<form method="post" action="delete-loan.do">
						<input type="hidden" id="id_loan" name="id_loan" value="${loan.id_loan}"> 
						<input type="hidden" id="id_user" name="id_user" value="${loan.id_user}"> 
						<input type="hidden" id="id_book" name="id_book" value="${loan.id_book }">
						
						<input type="submit" value="Delete Loan">
					</form>
				</td>
				<td>
					<form method="post" action="change-page.do">
						<input type="hidden" id="id_loan" name="id_loan" value="${loan.id_loan}"> 
						<input type="submit" value="Update State">
						<input type= "hidden" id="changePage" name=changePage value="updateLoan">
					</form>
				</td>
				<td>
					<form method="post" action="change-page.do">
						<input type="submit" value="Send remind">
						<input type= "hidden" id="changePage" name=changePage value="sendRemind">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form method="post" action="show-books.do">
		<input type="submit" value="Book List">
	</form>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>