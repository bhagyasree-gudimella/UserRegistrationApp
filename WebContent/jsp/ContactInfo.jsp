<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@include file="/jsp/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Contact Info Page</title>
</head>
<body>
	<h2>Contact Info Page</h2>
	<hr>
	<br>
	<form name="contactInfoForm" action="/UserRegistrationApp/ContactInfoServlet" method="get">
		Address  
		<input type="text" name="address" id="address"/><br><br>
		City 
		<input type="text" name="city" id="city"/><br><br>
		State 
		<input type="text" name="state" id="state"/><br><br>
		Country 
		<input type="text" name="country" id="country"/><br><br>
		ZIPCODE 
		<input type="text" name="pincode" id="pincode"/><br><br>
		Contact Number 
		<input type="text" name="phone" id="phone"/><br><br>
		
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form>
</body>
</html>