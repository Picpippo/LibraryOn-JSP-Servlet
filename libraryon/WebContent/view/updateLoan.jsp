<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Loan</title>
</head>
<body bgcolor="whitesmoke">
<form action="update-loan.do">
		<input type="hidden" id="id_loan" name="id_loan" >
		<label for="state">State: </label> 
	    <input type="text" id="state" name="state">
		<input type="submit" value="Modify">
</form>
</body>
</html>