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
<title>Create User</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>

	<h2>Create user</h2>

 <form method="post" action="create-user.do">

	<label for="name">Name: </label> 
	    <input type="text" id="name" name="name">
		<br><br>
    <label for="cognome">Surname: </label>
		<input type="text" id="surname" name="surname">
		<br><br>
	<label for="email">Address: </label> 
		<input type="text" id="address" name="address">
		<br><br>
	<label for="email">Email: </label> 
		<input type="text" id="email" name="email">
		<br><br>
	<label for="email">Password: </label> 
		<input type="text" id="password" name="password">
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