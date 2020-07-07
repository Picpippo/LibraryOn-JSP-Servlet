<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Book</title>
</head>
<body>
<form action="update-book.do">
		
		<label for="name">Title: </label> 
	    <input type="text" id="title" name="title">
			<br>
    	<label for="cognome">Author: </label>
		<input type="text" id="author" name="author">
			<br>
		<label for="email">Editor: </label> 
		<input type="text" id="editor" name="editor">
			<br>
		<label for="email">Quantity: </label> 
		<input type="text" id="quantity" name="quantity">
			<br>
		<label for="email">Position: </label> 
		<input type="text" id="position" name="position">
			<br>
    	<input type="submit" value="update">
    
	</form>
</body>
</html>