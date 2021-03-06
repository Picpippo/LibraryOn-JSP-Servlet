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
				<form method="post" action="change-page.do">
					<input type="submit" value="Create User">
					<input type= "hidden" id="changePage" name=changePage value="createUser">
				</form>
			</td>
			<td>
				<form method="post" action="show-role.do">
					<input type="submit" value="Show Roles">
				</form>
			</td>
			<td>
				<form method="post" action="change-page.do">
					<input type="submit" value="Exit">
					<input type= "hidden" id="changePage" name=changePage value="backHome">
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
					<form method="post" action="delete-user.do">
						<input type="hidden" id="id_user" name="id_user"
							value="${user.id_user}"> <input type="submit"
							value="Delete">
					</form>
				</td>

				<td>
					<form method="post" action="change-page.do">
						<input type="hidden" id="id_user" name="id_user"
							value="${user.id_user}"> <input type="submit"
							value="Update">
							<input type= "hidden" id="changePage" name=changePage value="updateUser">
					</form>
				</td>
				<td>
					<form method="post" action="change-pageCR.do">
						<input type="hidden" id="id_user" name="id_user" value="${user.id_user}"> 
							<input type="submit" value="Create Role">
							<input type= "hidden" id="changePage" name=changePage value="createRole">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<br>

	<div class="footer">
		<p>Copyrightę By SPB</p>
	</div>

</body>
</html>