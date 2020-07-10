<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body bgcolor="whitesmoke">
<form action="update-user.do">
		
		<input type="hidden" id="id_user" name="id_user" >
		<label for="name">Name: </label> 
	    <input type="text" id="name" name="name" value = "${name}">
			<br>
    	<label for="surname">Surname: </label>
		<input type="text" id="surname" name="surname" value = "${surname}">
			<br>
		<label for="address">Address: </label> 
		<input type="text" id="address" name="address" value = "${address}">
			<br>
		<label for="email">Email: </label> 
		<input type="text" id="email" name="email" value = "${email}">
			<br>
		<label for="password">Password: </label> 
		<input type="text" id="password" name="password" value = "${password}">
			<br>
    	<input type="submit" value="update">
	</form>
</body>
</html>