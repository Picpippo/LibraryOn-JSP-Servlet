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
<body>
	<form action="LibraryServlet.do">

		Please enter your email <input type="text" name="email" /><br>

		Please enter your password <input type="text" name="password" /> <input
			type="submit" value="submit">

	</form>
</body>
</html>