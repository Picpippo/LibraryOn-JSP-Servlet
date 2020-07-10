<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
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
  text-align : center;
  list-style-type: none;
  margin: 0;
  padding: 14px;
  background-color: black;
}

li{
color : white;
font-family: verdana;
font-size: 25px;
}

</style>

</head>
<body bgcolor="whitesmoke">

<ul><li>LibraryOn</li></ul>

    <br>
    <br>
    <br>
    <br>
    <hr>
    
    <h2>Login</h2>
	<form action="login.do">

		Please enter email:<br> <input type="text" name="email" /> <br>
		<br> Please enter password: <br> <input type="password"
			name="password" /> <br> <br> <input type="submit"
			value="Login">

	</form>
	<br>
	<hr>

	<div class="footer">
		<p>Copyright© By SPB</p>
	</div>
</body>

</html>