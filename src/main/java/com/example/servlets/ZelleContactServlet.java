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

import com.example.dao.BankAccountDao;
import com.example.dao.ZelleContactDao;
import com.example.models.BankAccount;
import com.example.models.User;
import com.example.models.ZelleContact;

/**
 * Servlet implementation class ZelleServlet
 */
public class ZelleContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZelleContactServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		ZelleContactDao zelleContactDao = new ZelleContactDao();
		List<ZelleContact> contacts = zelleContactDao.getZelleContacts(user.getUserId());
		
		request.setAttribute("contacts", contacts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/zelle.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		String contactName = request.getParameter("contact_name");
		int receiverId = Integer.parseInt(request.getParameter("receiver_id"));
		int contactId = Integer.parseInt(request.getParameter("contact_id"));
		
		ZelleContact contact = new ZelleContact(contactId, user.getUserId(), contactName, receiverId);

		session.setAttribute("contact", contact);
		
		response.sendRedirect(request.getContextPath() + "/zelle/transfer");
	}
}
