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

<title>Update Loan</title>
</head>
<body bgcolor="whitesmoke">
<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<hr>

	<h2>Update loan</h2>
	
<form method="post" action="update-loan.do">
		<input type="hidden" id="id_loan" name="id_loan" >
		<label for="state">State: </label> 
	    <input type="text" id="state" name="state">
		<input type="submit" value="Update">
</form>
<br>
<form method="post" action="show-loan.do">
		<input type="submit" value="Back">
	</form>
<br>
	<hr>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>