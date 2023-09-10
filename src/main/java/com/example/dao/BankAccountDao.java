package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.AccountType;
import com.example.models.BankAccount;
import com.example.models.SavingsAccount;
import com.example.util.DatabaseConnection;

public class BankAccountDao {
	private Connection connection;
	
	public BankAccountDao() {
		try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error initializing BankAccountDao", e);
		}
	}
	
	public List<BankAccount> getBankAccounts(int userId) {
		List<BankAccount> accounts = new ArrayList<>();
		String query = "SELECT * FROM bank_accounts WHERE user_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					BankAccount account;
					if (rs.getInt("account_type") == 1) {
						account = new BankAccount();
						account.setAccountType(AccountType.CHECKING);
					} else {
						account = new SavingsAccount();
						account.setAccountType(AccountType.SAVINGS);
					}
					account.setAccountId(rs.getInt("account_id"));
					account.setUserId(userId);
					account.setBalance(rs.getBigDecimal("balance"));
					accounts.add(account);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return accounts;
	}
}
