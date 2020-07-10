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

<title>Update Role</title>
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
	<br>
	<hr>

	<h2>Update role</h2>
	
<form action="update-role.do">
		
		<input type="hidden" id="id_role" name="id_role" >
		<label for="id_profile">Profile: </label> 
	    <input type="text" id="id_profile" name="id_profile">
		<input type="submit" value="Modify">
</form>
<br>
<form action="show-role.do">
		<input type="submit" value="Back">
	</form>
<br>
	<hr>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>