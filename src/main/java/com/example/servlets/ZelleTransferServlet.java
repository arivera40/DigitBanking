package com.example.servlets;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;

import com.example.dao.BankAccountDao;
import com.example.dao.TransactionDao;
import com.example.dao.ZelleContactDao;
import com.example.models.BankAccount;
import com.example.models.Transaction;
import com.example.models.TransactionType;
import com.example.models.User;
import com.example.models.ZelleContact;
import com.example.service.TransactionService;

/**
 * Servlet implementation class ZelleTransferServlet
 */
public class ZelleTransferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZelleTransferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		ZelleContact contact = (ZelleContact) session.getAttribute("contact");
		
		System.out.println(contact.getContactName());
		
		request.setAttribute("contact", contact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/zelle-transfer.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve data from post and session.
		HttpSession session = request.getSession();
		ZelleContact contact = (ZelleContact) session.getAttribute("contact");
		BigDecimal amount = TransactionService.convertToCurrency(request.getParameter("amount"));
		
		System.out.println(contact.getUserId());
		
		// Retrieve sender and receiver bank accounts.
		BankAccountDao bankAccountDao = new BankAccountDao();
		BankAccount fromAccount = bankAccountDao.getCheckingAccount(contact.getUserId());
		BankAccount toAccount = bankAccountDao.getCheckingAccount(contact.getReceiverId());
		
		// Create and fill zelle transaction.
		Transaction zelle = new Transaction();
		zelle.setTransactionType(TransactionType.ZELLE);
		zelle.setAmount(amount);
		zelle.setFromAccountId(fromAccount.getAccountId());
		zelle.setToAccountId(toAccount.getAccountId());
		
		// Add zelle transaction.
		TransactionDao transactionDao = new TransactionDao();
		boolean transactionSuccessful = transactionDao.addTransaction(zelle);
		
		// On success redirect to home.
		if (transactionSuccessful) {
			System.out.println("Success");
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			System.out.println("Fail");
		}
	}

}
