<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

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
<title>Create Role</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>

	<h2>Create role</h2>
	
<form method="post" action="create-role.do">

    <input type="hidden" id="id_user" name="id_user">

    <label for="id_profile">id Profile: </label>
		<input type="text" id="id_profile" name="id_profile">
		<br>
		<br>
	
    <input type="submit" value="Create">

	</form>
	<br>
	<form method="post" action="show-users.do">
		<input type="submit" value="Back">
	</form>
	<br>
	<hr>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>