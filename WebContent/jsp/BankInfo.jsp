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
<title>Bank Info Page</title>
</head>
<body>
	<h2>Bank Info Page</h2>
	<hr>
	<br>
	<form name="bankInfoForm" action="/UserRegistrationApp/BankInfoServlet" method="post"> 
		Bank Name  
		<input type="text" name="bank_name" id="bank_name"/><br><br>
		Account Details  
		<input type="text" name="account_details" id="account_details"/><br><br>
		SSN 
		<input type="text" name="ssn" id="ssn" placeholder="xxx-xx-xxxx"/><br><br>
		
		<input type="submit" name="submit_button" value="SUBMIT" class="submit_button" />
	</form>
</body>
</html>