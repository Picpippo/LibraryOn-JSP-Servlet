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
<title>Reminder</title>
</head>
<body bgcolor="whitesmoke">

<ul>
		<li>LibraryOn</li>
	</ul>
	<br>
	<hr>

	<h2>Send Reminder</h2>
	
<form method="post" action="send-reminder.do">

    <input type="hidden" id="id_user" name="id_user">

    <label for="email">Email: </label>
		<input type="text" id="email" name="email">
		<br><br>
		<label for="message">Message: </label>
		<textarea name="message" id="message">
		
		</textarea>
	<br>
	<br>
	</form>
	<form method="post" action="change-pageRem.do">
		 <input type="submit" value="Send">
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