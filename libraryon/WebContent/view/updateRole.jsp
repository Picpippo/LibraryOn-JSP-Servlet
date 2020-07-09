<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Loan</title>
</head>
<body>
<form action="update-role.do">
		
		<input type="hidden" id="id_role" name="id_role" >
		<label for="id_profile">Profile: </label> 
	    <input type="text" id="id_profile" name="id_profile">
		<input type="submit" value="Modify">
</form>
</body>
</html>