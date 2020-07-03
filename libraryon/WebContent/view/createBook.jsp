<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Book</title>
</head>
<body>
<form action="create-book.do">

	<label for="name">Title: </label> 
	    <input type="text" id="title" name="ftitle">
		<br>
    <label for="cognome">Author: </label>
		<input type="text" id="author" name="fauthor">
		<br>
	<label for="email">Editor: </label> 
		<input type="text" id="editor" name="feditor">
		<br>
	<label for="email">Quantity: </label> 
		<input type="text" id="quantity" name="fquantity">
		<br>
	<label for="email">Position: </label> 
		<input type="text" id="position" name="fposition">
		<br>
	
    <button name="createBook" onclick="createBook(Book book)">Create</button>

	</form>
</body>
</html>