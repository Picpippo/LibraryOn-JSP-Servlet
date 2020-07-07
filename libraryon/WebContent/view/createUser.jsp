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
	    <input type="text" id="name" name="name">
		<br>
    <label for="cognome">Surname: </label>
		<input type="text" id="surname" name="surname">
		<br>
	<label for="email">Address: </label> 
		<input type="text" id="address" name="address">
		<br>
	<label for="email">Email: </label> 
		<input type="text" id="email" name="email">
		<br>
	<label for="email">Password: </label> 
		<input type="text" id="password" name="password">
		<br>
	
    <button name="createUser" onclick="createUser(User user)">Create</button>

	</form>
</body>
</html>