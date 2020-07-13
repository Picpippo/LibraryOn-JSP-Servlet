<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="libraryon.model.Profile"%>
<%@page import="libraryon.model.User"%>
<%@page import="libraryon.model.Role"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Homepage</title>
<style>
body {
	text-align: center;
}

.footer {
	position: fixed;
	left: 0;
	bottom: 0;
	width: 100%;
	background-color: black;
	color: white;
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
</style>
</head>

<body bgcolor="whitesmoke">
	<ul>
		
		<li>LibraryOn</li>
	</ul>
	<br>
		<br>
		<br>
		<br>
	<form method="post" action="show-books.do">
		<input type="submit" value="Employee">
	</form>
	<br>
	<form method="post" action="show-users.do">
		<input type="submit" value="Administrator">
	</form>
	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>