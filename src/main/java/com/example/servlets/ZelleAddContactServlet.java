package com.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;

import com.example.dao.ZelleContactDao;
import com.example.models.User;
import com.example.models.ZelleContact;

/**
 * Servlet implementation class ZelleAddContactServlet
 */
public class ZelleAddContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZelleAddContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/add-contact.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String contactName = request.getParameter("contact_name");
		String phoneNumber = request.getParameter("phone_number");
		String email = request.getParameter("email");
		
		ZelleContactDao zelleContactDao = new ZelleContactDao();
		boolean createContactSuccessful = zelleContactDao.createZelleContact(user.getUserId(), contactName, phoneNumber, email);
		
		// On success redirect to zelle contacts page.
		if (createContactSuccessful) {
			response.sendRedirect(request.getContextPath() + "/zelle");
		} else {
			doGet(request, response);
		}
	}

}
