package com.lavanya.gudimella.controller;

import java.io.IOException; 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lavaya.gudimella.service.PersonServiceImpl;

public class AskForEmailAddressServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In Ask for email Servlet");
		
		PersonServiceImpl personBOImpl = new PersonServiceImpl();
		String email_address = request.getParameter("email");
		
		if(personBOImpl.findPerson(email_address)) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("email_address", email_address);
			response.sendRedirect("jsp/UpdatePerson.jsp");
		} else {
			System.out.println("Person not found");
			String result = "Email address not found in the database";
			request.setAttribute("result", result);
			RequestDispatcher rd =request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}
}
