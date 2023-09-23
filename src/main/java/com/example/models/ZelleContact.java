package com.example.models;

public class ZelleContact {
	private int contactId;
	private int userId;
	private String contactName;
	private String phoneNumber;
	private String email;
	
	public ZelleContact() {
		this.setContactId(0);
		this.setUserId(0);
		this.setContactName("");
		this.setPhoneNumber("");
		this.setEmail("");
	}
	
	public ZelleContact(int contactId, int userId, String contactName, String phoneNumber, String email) {
		this.setContactId(contactId);
		this.setUserId(userId);
		this.setContactName(contactName);
		this.setPhoneNumber(phoneNumber);
		this.setEmail(email);
	}

	/**
	 * @return the contactId
	 */
	public int getContactId() {
		return contactId;
	}

	/**
	 * @param contactId the contactId to set
	 */
	public void setContactId(int contactId) {
		this.contactId = contactId;
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
	 * @return the contactName
	 */
	public String getContactName() {
		return contactName;
	}

	/**
	 * @param contactName the contactName to set
	 */
	public void setContactName(String contactName) {
		this.contactName = contactName;
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
}
