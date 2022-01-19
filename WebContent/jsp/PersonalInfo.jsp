<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/jsp/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	<%@ include file="/css/StyleSheet.css" %>
</style>
<title>Personal Info Page</title>
</head>
<body>
	<h2>Personal Info Page</h2>
	<hr>
	<br>
	<form name="personalInfoForm" action="/UserRegistrationApp/PersonalInfoServlet" method="get">
		First Name 
		<input type="text" name="first_name" id="fname"/> <br><br>
		Middle Name 
		<input type="text" name="middle_name" id="mname"/> <br><br>
		Last Name 
		<input type="text" name="last_name" id="lname"/> <br><br>
		Email 
		<input type="text" name="email" id="email_id" placeholder="abc@domain.com"/> <br><br>
		Male <input type="radio" name="gender" id="male" value="male"/>
		Female <input type="radio" name="gender" id="female" value="female"/> <br><br>
		
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
		
	</form>

</body>
</html>