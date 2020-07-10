<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<title>Create Book</title>
</head>
<body bgcolor="whitesmoke">

	<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>

	<h2>Create book</h2>
	<form action="create-book.do">

		<label for="name">Title: </label> 
		<input type="text" id="title"name="title"> <br> <br>
		
		<label for="cognome">Author:</label> 
		<input type="text" id="author" name="author"> <br> <br> 
		
		<label for="email">Editor: </label> 
		<input type="text" id="editor" name="editor"> <br> <br>
		
		<label for="email">Quantity:</label> 
		<input type="text" id="quantity" name="quantity"> <br> <br> 
		
		<label for="email">Position: </label>	 
		<input type="text" id="position" name="position"> <br> <br> 
		
		<input type="submit" value="Create Book">

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