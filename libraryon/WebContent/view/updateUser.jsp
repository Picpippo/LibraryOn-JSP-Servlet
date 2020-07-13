<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<title>Update User</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>

	<h2>Update user</h2>
	
<form method="post" action="update-user.do">
		
		<input type="hidden" id="id_user" name="id_user" >
		
		<label for="name">Name: </label> 
	    <input type="text" id="name" name="name" value = "${name}">
			<br><br>
    	<label for="surname">Surname: </label>
		<input type="text" id="surname" name="surname" value = "${surname}">
			<br><br>
		<label for="address">Address: </label> 
		<input type="text" id="address" name="address" value = "${address}">
			<br><br>
		<label for="email">Email: </label> 
		<input type="text" id="email" name="email" value = "${email}">
			<br><br>
		<label for="password">Password: </label> 
		<input type="text" id="password" name="password" value = "${password}">
			<br><br>
    	<input type="submit" value="Update">
    	<br><br>
	</form>
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