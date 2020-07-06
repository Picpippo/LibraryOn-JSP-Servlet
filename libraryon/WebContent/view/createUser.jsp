<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create user</title>
</head>
<body>
<form action="create-user.do">

	<label for="name">Name: </label> 
	    <input type="text" id="name" name="fname">
		<br>
    <label for="cognome">Surname: </label>
		<input type="text" id="surname" name="fsurname">
		<br>
	<label for="email">Address: </label> 
		<input type="text" id="address" name="faddress">
		<br>
	<label for="email">Email: </label> 
		<input type="text" id="email" name="femail">
		<br>
	<label for="email">Password: </label> 
		<input type="text" id="password" name="fpassword">
		<br>
	
    <button name="createUser" onclick="createUser(User user)">Create</button>

	</form>
</body>
</html>