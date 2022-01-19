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

public class BankInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Bank Info Servlet");
		
		String bank_name = request.getParameter("bank_name");
		String account_details = request.getParameter("account_details");
		String ssn_number = request.getParameter("ssn");
		
		//get the person httpSession 
		HttpSession httpSession = request.getSession();
		Person person = (Person) httpSession.getAttribute("personInfo");
		
		// Bank info form validation
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		String result = null;
		
		try {
			personBOImpl.validateBankInfo(bank_name, account_details, ssn_number);
		} catch (PersonFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}
				
		if(result==null) {
			//set the input values to person
			person.setBank_name(bank_name);
			person.setAccount_details(account_details);
			person.setSsn_number(ssn_number);

			//check if person already registered in database or not
			if(personBOImpl.findPerson(person.getEmail_address())) {
				System.out.println("Person already registered");
				result = "Person already registered";
				request.setAttribute("result", result);
				RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
				rd.forward(request, response);
			} else {
				//if person doen't exists in database, then register the person
				personBOImpl.addPerson(person);
				System.out.println(person.getFirst_name());
				System.out.println(person.getAddress());
				System.out.println(person.getSsn_number());
				response.sendRedirect("jsp/RegistrationSuccess.jsp");
			}
		} else {
			request.setAttribute("result", result);
			RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
		
	}
}