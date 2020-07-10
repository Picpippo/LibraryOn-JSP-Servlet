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
<title>Administration</title>

</head>
<body bgcolor="whitesmoke">
	<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<table class="center">
		<tr>
			<td>
				<form action="change-pageCU.do">
					<input type="submit" value="Create User">
				</form>
			</td>
			<td>
				<form action="show-role.do">
					<input type="submit" value="Show Roles">
				</form>
			</td>
			<td>
				<form action="back-home.do">
					<input type="submit" value="Exit">
				</form>
			</td>
		</tr>
	</table>

	<br>
	<table border=1 class="center">
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
				<td>
					<form action="delete-user.do">
						<input type="hidden" id="id_user" name="id_user"
							value="${user.id_user}"> <input type="submit"
							value="Delete">
					</form>
				</td>

				<td>
					<form action="change-pageUU.do">
						<input type="hidden" id="id_user" name="id_user"
							value="${user.id_user}"> <input type="submit"
							value="Update">
					</form>
				</td>
				<td>
					<form action="change-pageCR.do">
						<input type="hidden" id="id_user" name="id_user"
							value="${user.id_user}"> <input type="submit"
							value="Create Role">
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