package com.lavanya.gudimella.controller;

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lavanya.gudimella.model.Person;
import com.lavaya.gudimella.service.PersonServiceImpl;

public class UpdatePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Update Person Servlet");
		
		HttpSession httpSession = request.getSession();
		String email_address = (String) httpSession.getAttribute("email_address");
		
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String pincode = request.getParameter("pincode");
		String phone_number = request.getParameter("phone");
		String bank_name = request.getParameter("bank_name");
		String account_details = request.getParameter("account_details");
		
		Person person = new Person();
		person.setEmail_address(email_address);
		person.setAddress(address);
		person.setCity(city);
		person.setState(state);
		person.setCountry(country);
		person.setZipcode(pincode);
		person.setPhone_number(phone_number);
		person.setBank_name(bank_name);
		person.setAccount_details(account_details);
		
		//update person details in database
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		personBOImpl.updatePerson(person);
		String result = "Dear, " + email_address + ". Your details has been successfully updated";
		request.setAttribute("result", result);
		RequestDispatcher rd = request.getRequestDispatcher("jsp/Success.jsp");
		rd.forward(request, response);
	}
}
