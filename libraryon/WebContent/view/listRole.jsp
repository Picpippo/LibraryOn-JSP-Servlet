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
<title>Role list</title>

</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<br>
	<br>
	<table border=1 class="center">
		<tr>
			<th>id_role</th>
			<th>id_user</th>
			<th>id_profile</th>

		</tr>
		<c:forEach items="${roleList}" var="role">
			<tr>
				<td>${role.id_role}</td>
				<td>${role.id_user}</td>
				<td>${role.id_profile}</td>
				<td>
					<form action="delete-role.do">
						<input type="hidden" id="id_role" name="id_role"
							value="${role.id_role}"> <input type="submit"
							value="Delete">
					</form>
				</td>
				<td>
					<form action="change-pageUR.do">
						<input type="hidden" id="id_role" name="id_role"
							value="${role.id_role}"> <input type="submit"
							value="Update">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<form action="show-users.do">
		<input type="submit" value="User List">
	</form>
	
	<br>
	<br>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>