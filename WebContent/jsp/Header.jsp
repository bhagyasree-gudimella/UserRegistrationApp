<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Welcome Page</title>
</head>
<body>
	<h2>Welcome Page</h2>
	<hr>
	<br>
	<a href="/UserRegistrationApp/jsp/Header.jsp">Home</a> <br>
	<a href="/UserRegistrationApp/jsp/PersonalInfo.jsp">Register Person</a> <br>
	<a href="/UserRegistrationApp/GetPersonListServlet">View Persons List</a> <br>
	<a href="/UserRegistrationApp/jsp/AskForEmailAddress.jsp">Update Person</a> <br>
	<a href="/UserRegistrationApp/jsp/DeletePerson.jsp">Delete Person</a> 
</body>
</html>