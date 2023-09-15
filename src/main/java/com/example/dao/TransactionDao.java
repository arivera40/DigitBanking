package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.Transaction;
import com.example.models.TransactionType;
import com.example.service.TransactionService;
import com.example.util.DatabaseConnection;

public class TransactionDao {
	private Connection connection;
	
	public TransactionDao() {
		try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error initializing TransactionDao", e);
		}
	}
	
	public boolean addTransaction(Transaction transaction) {
		String query = "INSERT INTO transactions (transaction_type, amount, from_account_id, to_account_id) VALUES (?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			int fromAccountId = transaction.getFromAccountId();
			int toAccountId = transaction.getToAccountId();
			System.out.println(fromAccountId);
	
			stmt.setInt(1, transaction.getTransactionType().getValue());
			stmt.setBigDecimal(2, transaction.getAmount());
			
			// Send null if fromAccountId is not set.
			if (fromAccountId != 0) {
				stmt.setInt(3, fromAccountId);
			} else {
				stmt.setNull(3, java.sql.Types.INTEGER);
			}
			
			// Send null if toAccountId is not set.
			if (toAccountId != 0) {
				stmt.setInt(4, toAccountId);
			} else {
				stmt.setNull(4, java.sql.Types.INTEGER);
			}

			int rowsInserted = stmt.executeUpdate();
			if (rowsInserted > 0) {
				switch(transaction.getTransactionType()) {
					case DEPOSIT:
						TransactionService.performDeposit(transaction);
						break;
					case WITHDRAW:
						TransactionService.performWithdraw(transaction);
						break;
					case TRANSFER:
						TransactionService.performTransfer(transaction);
						break;
					case ZELLE:
						TransactionService.performZelle(transaction);
						break;
				}
			}
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public List<Transaction> getAllTransactions(int bankAccountId) {
		List<Transaction> transactions = new ArrayList<>();
		String query = "SELECT * FROM transactions WHERE from_account_id = ? or to_account_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, bankAccountId);
			stmt.setInt(2, bankAccountId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					Transaction transaction = new Transaction();
					transaction.setTransactionId(rs.getInt("transaction_id"));
					transaction.setTransactionType(TransactionType.setType(rs.getInt("transaction_type")));
					transaction.setAmount(rs.getBigDecimal("amount"));
					transaction.setFromAccountId(rs.getInt("from_account_id"));
					transaction.setToAccountId(rs.getInt("to_account_id"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return transactions;
	}

}
