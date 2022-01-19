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
<title>Ask via Email</title>
</head>
<body>
	<h2>Email Address</h2>
	<hr>
	<br>
	<form action="/UserRegistrationApp/AskForEmailAddressServlet" method="get">
		Email 
		<input type="text" name="email" id="email_id" placeholder="Your email .. " required/> <br><br>
		
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form>
</body>
</html>