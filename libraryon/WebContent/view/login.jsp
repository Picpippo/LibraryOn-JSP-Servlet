<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<style>
body {
	text-align: center;
}
</style>
</head>
<body bgcolor="whitesmoke">
	<form action="LibraryServlet.do">

		Please enter email:<br> <input type="text" name="email" /> <br>
		<br> Please enter password: <br> <input type="text"
			name="password" /> <br>
		<br> <input type="submit" value="submit">

	</form>
</body>
</html>