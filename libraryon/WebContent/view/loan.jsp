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
<title>Create loan</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<br>
	<hr>

	<h2>Create loan</h2>
	
<form method="post" action="create-loan.do">

    <input type="hidden" id="id_book" name="id_book">

	<label for="id_user">id User: </label> 
	    <input type="text" id="id_user" name="id_user">
		<br><br>
    <label for="assigment_date">Assignment date: </label>
		<input type="text" id="assignment_date" name="assignment_date">
		<br><br>
	<label for="expiration_date">Expiration date: </label> 
		<input type="text" id="expiration_date" name="expiration_date">
		<br><br>
	<label for="state">State: </label> 
		<input type="text" id="state" name="state">
		<br><br>
		
    <input type="submit" value="Create">

	</form>
	<br>
	<form method="post" action="show-books.do">
		<input type="submit" value="Back">
	</form>
	<br>
	<hr>
	
	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>

</html>