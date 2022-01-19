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

public class PersonalInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		System.out.println("In Personal Info Servlet");
		
		String first_name = request.getParameter("first_name");
		String middle_name = request.getParameter("middle_name");
		String last_name = request.getParameter("last_name");
		String email_address = request.getParameter("email");
		String gender = request.getParameter("gender");
		
		//personal info form validation
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		String result = null;
		
		try {
			personBOImpl.validatePersonalInfo(first_name, middle_name, last_name, email_address);
		} catch (PersonFormValidationException e) {
			result = e.getErrorMessage();
			e.printStackTrace();
		}

		
		if(result==null) {
			//set the values to person object
			Person person = new Person();
			person.setFirst_name(first_name);
			person.setMiddle_name(middle_name);
			person.setLast_name(last_name);
			person.setEmail_address(email_address);
			person.setGender(gender);
			
			//add person to httpSession
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("personInfo", person);
			response.sendRedirect("jsp/ContactInfo.jsp");
		} else {
			request.setAttribute("result", result);
			RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}
}

