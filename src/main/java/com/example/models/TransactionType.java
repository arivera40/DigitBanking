package com.example.models;

public enum TransactionType {
	DEPOSIT(1, "DEPOSIT"),
    WITHDRAW(2, "WITHDRAW"),
    TRANSFER(3, "TRANSFER"),
    ZELLE(4, "ZELLE");
	
	private final int value;
    private final String description;
	
    TransactionType(int value, String description) {
        this.value = value;
        this.description = description;
    }
	
    public static TransactionType setType(int value) {
        for (TransactionType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid transaction type value: " + value);
    }

	/**
	 * @return the value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
}
