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
	<br>
	<br>
	<table border=1>
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
					<form action="delete-loan.do">
						<input type="hidden" id="id_loan" name="id_loan"
							value="${loan.id_loan}"> <input type="hidden"
							id="id_user" name="id_user" value="${loan.id_user}"> <input
							type="submit" value="Delete Loan">
					</form>
				</td>
				<td>
					<form action="change-pageUL.do">
						<input type="hidden" id="id_loan" name="id_loan"
							value="${loan.id_loan}"> <input type="submit"
							value="Update State">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="show-books.do">
		<input type="submit" value="Book List">
	</form>
</body>
</html>