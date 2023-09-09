package com.example.models;

import java.math.BigDecimal;

public class Transaction {
	private int transactionId;
	private TransactionType transactionType;
	private BigDecimal amount;
	private int fromAccountId;
	private int toAccountId;
	
	public Transaction() {
		this.transactionId = 0;
		this.transactionType = null;
		this.amount = null;
		this.fromAccountId = 0;
		this.toAccountId = 0;
	}
	
	public Transaction(int transactionId, TransactionType transactionType, BigDecimal amount, int fromAccountId, int toAccountId) {
		this.transactionId = transactionId;
		this.transactionType = transactionType;
		this.amount = amount;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
	}

	/**
	 * @return the transactionId
	 */
	public int getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the transactionType
	 */
	public TransactionType getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(TransactionType transactionType) {
		this.transactionType = transactionType;
	}

	/**
	 * @return the amount
	 */
	public BigDecimal getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	/**
	 * @return the fromAccountId
	 */
	public int getFromAccountId() {
		return fromAccountId;
	}

	/**
	 * @param fromAccountId the fromAccountId to set
	 */
	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}

	/**
	 * @return the toAccountId
	 */
	public int getToAccountId() {
		return toAccountId;
	}

	/**
	 * @param toAccountId the toAccountId to set
	 */
	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}
	
	
}
