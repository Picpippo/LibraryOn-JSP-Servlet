<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reminder Sent!</title>
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
</head>
<body>
<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>

	<h2>Send Reminder</h2>
E-mail sent!!!
<br><br>
<form method="post" action="show-loan.do">
		<input type="submit" value="Back">
	</form>
<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>
</html>