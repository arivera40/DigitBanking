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
 * Servlet implementation class WithdrawServlet
 */
public class WithdrawServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public WithdrawServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("user");
		
		BankAccountDao bankAccountDao = new BankAccountDao();
		List<BankAccount> accounts = bankAccountDao.getBankAccounts(user.getUserId());
		
		request.setAttribute("accounts", accounts);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/withdraw.jsp");
	    dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Retrieve data from post.
		int fromAccountId = Integer.parseInt(request.getParameter("fromAccountId"));
		BigDecimal amount = TransactionService.convertToCurrency(request.getParameter("amount"));
		
		// Create and fill withdraw transaction.
		Transaction withdraw = new Transaction();
		withdraw.setTransactionType(TransactionType.WITHDRAW);
		withdraw.setAmount(amount);
		withdraw.setFromAccountId(fromAccountId);
		
		// Add withdraw transaction.
		TransactionDao transactionDao = new TransactionDao();
		boolean transactionSuccessful = transactionDao.addTransaction(withdraw);
		
		// On success redirect to home.
		if (transactionSuccessful) {
			System.out.println("Success");
			response.sendRedirect(request.getContextPath() + "/home");
		} else {
			System.out.println("Fail");
		}
	}

}
