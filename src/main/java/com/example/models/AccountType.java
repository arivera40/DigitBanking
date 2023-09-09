package com.example.models;

public enum AccountType {
	CHECKING(1, "CHECKING"),
    SAVINGS(2, "SAVINGS");
	
	private final int value;
    private final String description;
	
    AccountType(int value, String description) {
        this.value = value;
        this.description = description;
    }
	
    public static AccountType setType(int value) {
        for (AccountType type : values()) {
            if (type.value == value) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid account type value: " + value);
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
