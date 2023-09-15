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
import com.example.models.BankAccount;
import com.example.models.Transaction;
import com.example.models.TransactionType;
import com.example.models.User;
import com.example.service.TransactionService;

/**
 * Servlet implementation class DepositServlet
 */
public class DepositServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepositServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Enters deposit get");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		BankAccountDao bankAccountDao = new BankAccountDao();
		List<BankAccount> accounts = bankAccountDao.getBankAccounts(user.getUserId());
		
		request.setAttribute("accounts", accounts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/deposit.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve data from post
		int accountId = Integer.parseInt(request.getParameter("selectedAccount"));
		BigDecimal amount = TransactionService.convertToCurrency(request.getParameter("amount"));
		
		// Create and fill deposit transaction.
		Transaction deposit = new Transaction();
		deposit.setTransactionType(TransactionType.DEPOSIT);
		deposit.setAmount(amount);
		deposit.setToAccountId(accountId);
		
		// Add deposit transaction.
		TransactionDao transactionDao = new TransactionDao();
		boolean transactionSuccessful = transactionDao.addTransaction(deposit);
		
		// On success redirect to home.
		if (transactionSuccessful) {
			System.out.println("Success");
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			System.out.println("Fail");
		}
	}

}
