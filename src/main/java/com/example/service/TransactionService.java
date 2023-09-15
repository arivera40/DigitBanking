package com.example.service;

import java.math.BigDecimal;
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
    	String fromQuery = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
    	String toQuery = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
        try (PreparedStatement stmtFrom = connection.prepareStatement(fromQuery);
        		PreparedStatement stmtTo = connection.prepareStatement(toQuery)) {
        	
           // Execute the 'from_query' statement.
           stmtFrom.setBigDecimal(1, transaction.getAmount());
           stmtFrom.setInt(2, transaction.getFromAccountId());
           int rowsUpdatedFrom = stmtFrom.executeUpdate();

           // Execute the 'to_query' statement.
           stmtTo.setBigDecimal(1, transaction.getAmount());
           stmtTo.setInt(2, transaction.getToAccountId());
           int rowsUpdatedTo = stmtTo.executeUpdate();

           return (rowsUpdatedFrom > 0 && rowsUpdatedTo > 0) ? true : false;
        } catch (SQLException e) {
        	e.printStackTrace();
        	return false;
        }
    }

    public static boolean performZelle(Transaction transaction) {
    	String fromQuery = "UPDATE bank_accounts SET balance = balance - ? WHERE account_id = ?";
    	String toQuery = "UPDATE bank_accounts SET balance = balance + ? WHERE account_id = ?";
    	return true;
    }
    
    public static BigDecimal convertToCurrency(String amount) {
    	return new BigDecimal(amount.replaceAll("[^\\d.]", ""));
    }
}
