<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create role</title>
</head>
<body bgcolor="whitesmoke">
<form action="create-role.do">

    <input type="hidden" id="id_user" name="id_user">

    <label for="id_profile">Profilo: </label>
		<input type="text" id="id_profile" name="id_profile">
		<br>
		<br>
	
    <input type="submit" value="Create">

	</form>
</body>
</html>