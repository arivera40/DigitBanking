package com.example.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.example.models.Transaction;
import com.example.util.DatabaseConnection;

public class TransactionService {
	private static Connection connection;
	
	static {
		try {
			connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error initializing TransactionService", e);
		}
	}
	
    public static boolean performDeposit(Transaction transaction) {
        String query = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	stmt.setBigDecimal(1, transaction.getAmount());
        	stmt.setInt(2, transaction.getToAccountId());
        	int rowsUpdated = stmt.executeUpdate();
        	return rowsUpdated > 0;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }

    public static boolean performWithdraw(Transaction transaction) {
        String query = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
        	stmt.setBigDecimal(1, transaction.getAmount());
        	stmt.setInt(2, transaction.getFromAccountId());
        	int rowsUpdated = stmt.executeUpdate();
        	return rowsUpdated > 0;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }

    public static boolean performTransfer(Transaction transaction) {
    	String from_query = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
    	String to_query = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
    	return true;
    }

    public static boolean performZelle(Transaction transaction) {
    	String from_query = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
    	String to_query = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
        // Your logic for Zelle transactions
    	return true;
    }
}
