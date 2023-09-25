package com.example.models;

public class ZelleContact {
	private int contactId;
	private int userId;
	private String contactName;
	private int receiverId;
	
	public ZelleContact() {
		this.contactId = 0;
		this.userId = 0;
		this.contactName = "";
		this.receiverId = 0;
	}
	
	public ZelleContact(int contactId, int userId, String contactName, int receiverId) {
		this.contactId = contactId;
		this.userId = userId;
		this.contactName = contactName;
		this.receiverId = receiverId;
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
	 * @return the receiverId
	 */
	public int getReceiverId() {
		return receiverId;
	}

	/**
	 * @param receiverId the receiverId to set
	 */
	public void setReceiverId(int receiverId) {
		this.receiverId = receiverId;
	}


}
