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

	<label for="id_user">id User: </label> 
	    <input type="text" id="id_user" name="id_user">
		<br>
    <label for="assigment_date">Assignment date: </label>
		<input type="text" id="assignment_date" name="assignment_date">
		<br>
	<label for="expiration_date">Expiration date: </label> 
		<input type="text" id="expiration_date" name="expiration_date">
		<br>
	<label for="state">State: </label> 
		<input type="text" id="state" name="state">
		<br>
	<br>
    <input type="submit" value="Create">

	</form>
</body>

</html>