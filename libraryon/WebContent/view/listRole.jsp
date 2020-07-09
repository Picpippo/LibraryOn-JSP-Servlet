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
</body>
</html>