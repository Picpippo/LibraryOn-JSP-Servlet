<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create loan</title>
</head>
<body>
<form action="create-loan.do">

    <input type="hidden" id="id_book" name="id_book">

	<label for="name">id User: </label> 
	    <input type="text" id="id_user" name="id_user">
		<br>
    <label for="cognome">Assignment date: </label>
		<input type="text" id="assignment_date" name="assignment_date">
		<br>
	<label for="email">Expiration date: </label> 
		<input type="text" id="expiration_date" name="expiration_date">
		<br>
	<label for="email">State: </label> 
		<input type="text" id="state" name="state">
		<br>
	
    <input type="submit" value="Create">

	</form>
</body>
</html>