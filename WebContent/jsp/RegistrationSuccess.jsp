<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="com.lavanya.gudimella.model.Person" %>
     <%@include file="/jsp/Header.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@ include file="/css/StyleSheet.css" %>
</style>
<meta charset="UTF-8">
<title>Success Page</title>
</head>
<body>
	<h2>Registration Success</h2>
	<hr>
	<br>
	<%
		Person person = (Person) session.getAttribute("personInfo");
		if (person != null) {
			out.println("Dear, " + person.getFirst_name() + " " + person.getMiddle_name() + " " + person.getLast_name());
		}
	%>
	
	<h2>You have been successfully registered</h2>
	
	<jsp:useBean id="personInfo" class="com.lavanya.gudimella.model.Person" scope="session"></jsp:useBean>
	
		<table border="1" cellpadding="15"> 
			<tr>
				<th>Personal Information</th>
				<th>Contact Information</th>
				<th>Bank Information</th>
			</tr>
			
			<tr>
				<td>
					First Name : <jsp:getProperty property="first_name" name="personInfo"/>  <br>
					Middle Name : <jsp:getProperty property="middle_name" name="personInfo"/>  <br>
					Last Name : <jsp:getProperty property="last_name" name="personInfo"/>  <br>
					Email : <jsp:getProperty property="email_address" name="personInfo"/>  <br>
					Gender : <jsp:getProperty property="gender" name="personInfo"/>  <br>
				</td>
				
				<td>
					Address : <jsp:getProperty property="address" name="personInfo"/>  <br>
					City : <jsp:getProperty property="city" name="personInfo"/>  <br>
					State : <jsp:getProperty property="state" name="personInfo"/>  <br>
					Country : <jsp:getProperty property="country" name="personInfo"/>  <br>
					Contact : <jsp:getProperty property="phone_number" name="personInfo"/>  <br>
					ZIPCODE : <jsp:getProperty property="zipcode" name="personInfo"/>  <br>
				</td>
				
				<td>
					Bank Name : <jsp:getProperty property="bank_name" name="personInfo"/>  <br>
					Account Details : <jsp:getProperty property="account_details" name="personInfo"/>  <br>
					SSN : <jsp:getProperty property="ssn_number" name="personInfo"/>  <br> 
				</td>
			</tr>
		</table>
</body>
</html>