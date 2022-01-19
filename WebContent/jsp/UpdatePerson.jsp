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
<title>Insert title here</title>
</head>
<body>
	<h2>Update Person</h2>
	<p>Welcome, <i>${email_address}</i> </p>
	<hr>
	<br>
	<form action="/UserRegistrationApp/UpdatePersonServlet" method="post">
		Address  
		<input type="text" name="address" id="address" required/><br><br>
		City 
		<input type="text" name="city" id="city"/><br><br>
		State 
		<input type="text" name="state" id="state" required/><br><br>
		Country 
		<input type="text" name="country" id="country"required/><br><br>
		ZIPCODE 
		<input type="text" name="pincode" id="pincode" required/><br><br>
		Contact Number 
		<input type="text" name="phone" id="phone"/><br><br>
		Bank Name  
		<input type="text" name="bank_name" id="bank_name" required/><br><br>
		Account Details  
		<input type="text" name="account_details" id="account_details" required/><br><br>
		
		<input type="submit" name="submit_button" value="UPDATE" class="submit_button" />
	</form>
</body>
</html>