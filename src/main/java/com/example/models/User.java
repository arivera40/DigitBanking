package com.example.models;

public class User {
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String ***REMOVED***;
	
	public User() {
		this.setUserId(0);
		this.firstName = "";
		this.lastName = "";
		this.email = "";
		this.phoneNumber = "";
		this.***REMOVED*** = "";
	}
	
	public User(String firstName, String lastName, String email, String ***REMOVED***) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = null;
		this.***REMOVED*** = ***REMOVED***;
	}
	
	public User(String firstName, String lastName, String email, String phoneNumber, String ***REMOVED***) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.***REMOVED*** = ***REMOVED***;
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
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the ***REMOVED***
	 */
	public String getPassword() {
		return ***REMOVED***;
	}

	/**
	 * @param ***REMOVED*** the ***REMOVED*** to set
	 */
	public void setPassword(String ***REMOVED***) {
		this.***REMOVED*** = ***REMOVED***;
	}
	
	
}