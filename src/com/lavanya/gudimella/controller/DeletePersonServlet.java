package com.lavanya.gudimella.controller;

import java.io.IOException; 

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lavaya.gudimella.service.PersonServiceImpl;

public class DeletePersonServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In delete person servlet");
		
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		String email_address = request.getParameter("email");
		
		//delete the person from database
		if(personBOImpl.findPerson(email_address)) {
			personBOImpl.deletePerson(email_address);
			String result = "Dear, " + email_address + ". Your details has been successfully deleted";
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/Success.jsp");
			rd.forward(request, response);
		} else {
			System.out.println("Person not found");
			String result = "Person does not exists in database";
			request.setAttribute("result", result);
			RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}
}
