package com.lavanya.gudimella.controller;

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lavanya.gudimella.model.Person;
import com.lavanya.gudimella.validations.PersonFormValidationException;
import com.lavaya.gudimella.service.PersonServiceImpl;
 
public class ContactInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Contact Info Servlet");
		
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String pincode = request.getParameter("pincode");
		String phone_number = request.getParameter("phone");
		
		//get the person httpSession 
		HttpSession httpSession = request.getSession();
		Person person = (Person) httpSession.getAttribute("personInfo");
		
		//Contact info form validation
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		String result = null;
		
		try {
			personBOImpl.validateContactInfo(address, city, state, country, pincode, phone_number);
		} catch (PersonFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
	
		if(result==null) {
			//set the input value to httpSession person object
			person.setAddress(address);
			person.setCity(city);
			person.setState(state);
			person.setCountry(country);
			person.setZipcode(pincode);
			person.setPhone_number(phone_number);
			response.sendRedirect("jsp/BankInfo.jsp");
		} else {
			request.setAttribute("result", result);
			RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}
}





//// person form validations
//PersonFormValidation personFormValidation = new PersonFormValidation();
//String result = null;
//
//if(personFormValidation.containsNumbers(city) || personFormValidation.containsSpecialCharacters(city)) {
//	result = "City name should contain only alphabets";
//} else if(personFormValidation.containsNumbers(state) || personFormValidation.containsSpecialCharacters(state)) {
//	result = "State name should contain only alphabets";
//} else if(personFormValidation.containsNumbers(country) || personFormValidation.containsSpecialCharacters(country)) {
//	result = "Country name should contain only alphabets";
//} else if(personFormValidation.containsAlphabets(pincode) || personFormValidation.containsSpecialCharacters(pincode)) {
//	result = "Pincode should contain only numbers";
//} else if(personFormValidation.validateContactNumber(phone_number)!=null) {
//	result = personFormValidation.validateContactNumber(phone_number);
//}
