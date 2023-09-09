package com.example.models;

import java.math.BigDecimal;

public class BankAccount {
	private int accountId;
	private int userId;
	private BigDecimal balance;
	
	public BankAccount() {
		this.setAccountId(0);
		this.setUserId(0);
		this.setBalance(null);
	}
	
	public BankAccount(int accountId, int userId, BigDecimal balance) {
		this.setAccountId(accountId);
		this.setUserId(userId);
		this.setBalance(balance);
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return accountId;
	}

	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the balance
	 */
	public BigDecimal getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}
}
