package com.example.servlets;

import jakarta.servlet.http.HttpServlet;
import java.io.IOException;

import com.example.dao.UserDao;
import com.example.models.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegistrationServlet
 */
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistrationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve form data
		String firstName = request.getParameter("first_name");
		String lastName = request.getParameter("last_name");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phone_number");
		String password = request.getParameter("password");
		
		if (firstName == null || lastName == null || email == null || phoneNumber == null || password == null) {
			System.out.println(firstName);
			System.out.println(lastName);
			System.out.println(email);
			System.out.println(phoneNumber);
			System.out.println(password);
			String errorMessage = "Please fill in all fields to register.";
		    request.setAttribute("fieldError", errorMessage);
		    RequestDispatcher dispatcher = request.getRequestDispatcher("/register.jsp");
		    dispatcher.forward(request, response);
		    return;
		}
		
		// Create a User object
		User newUser = new User(firstName, lastName, email, phoneNumber, password);
		
		// Add User to database
		UserDao userDao = new UserDao();
		boolean registrationSuccessful = userDao.registerUser(newUser);
		
		if (registrationSuccessful) {
			System.out.println("Success");
		} else {
			System.out.println("Fail");
		}
	}

}
