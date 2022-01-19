package com.lavanya.gudimella.controller;

import java.io.IOException; 
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.lavanya.gudimella.model.Person;
import com.lavaya.gudimella.service.PersonServiceImpl;

public class GetPersonListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In get all persons List Servlet");
		
		PersonServiceImpl personBOImpl = new  PersonServiceImpl();
		ArrayList<Person> personsList = new ArrayList<Person>();
		
		personsList = personBOImpl.getAllPersonsList();
		if(!personsList.isEmpty()) {
			request.setAttribute("personsList", personsList);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/ViewPersonList.jsp");
			rd.forward(request, response);
		} else {
			String result = "Persons Database is Empty";
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("jsp/ErrorPage.jsp");
			rd.forward(request, response);
		}
	}
}
