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

<title>Update Book</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>
	<h2>Update book</h2>
	
<form action="update-book.do">
		
		<input type="hidden" id="id_book" name="id_book">
		
		<label for="name">Title: </label> 
	    <input type="text" id="title" name="title" value= "${title}">
			<br><br>
    	<label for="cognome">Author: </label>
		<input type="text" id="author" name="author" value= "${author}">
			<br><br>
		<label for="email">Editor: </label> 
		<input type="text" id="editor" name="editor" value= "${editor}">
			<br><br>
		<label for="email">Quantity: </label> 
		<input type="text" id="quantity" name="quantity" value= "${quantity}">
			<br><br>
		<label for="email">Position: </label> 
		<input type="text" id="position" name="position" value= "${position}">
			<br><br>
    	
    	<input type="submit" value="Update">
    
	</form>
	<br>
	<form action="show-books.do">
		<input type="submit" value="Back">
	</form>
	
	<br>
	<hr>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>