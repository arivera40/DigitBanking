package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.models.ZelleContact;
import com.example.util.DatabaseConnection;

public class ZelleContactDao {
	private Connection connection;
	
	public ZelleContactDao() {
		try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error initializing ZelleContactDao");
		}
	}
	
	public List<ZelleContact> getZelleContacts(int userId) {
		List<ZelleContact> contacts = new ArrayList<>();
		String query = "SELECT * FROM zelle_contacts WHERE user_id = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setInt(1, userId);
			
			try (ResultSet rs = stmt.executeQuery()) {
				while (rs.next()) {
					ZelleContact contact = new ZelleContact();
					contact.setContactId(rs.getInt("contact_id"));
					contact.setUserId(userId);
					contact.setContactName(rs.getString("contact_name"));
					contact.setReceiverId(rs.getInt("receiver_id"));
					contacts.add(contact);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return contacts;
	}
	
	public boolean createZelleContact(int userId, String contactName, String phoneNumber, String email) {
		// Prepare search query to find receiver id.
		String searchQuery = "SELECT * FROM users WHERE phone_number = ? OR email = ?";
		try (PreparedStatement searchStmt = connection.prepareStatement(searchQuery)) {
			searchStmt.setString(1, phoneNumber);
			searchStmt.setString(2, email);
			ResultSet searchRs = searchStmt.executeQuery();
			
			// If receiver id found, insert new zelle contact to table.
			if (searchRs.next()) {
				String insertQuery = "INSERT INTO zelle_contacts (user_id, contact_name, receiver_id) VALUES (?, ?, ?)";
				try (PreparedStatement insertStmt = connection.prepareStatement(insertQuery)) {
					insertStmt.setInt(1, userId);
					insertStmt.setString(2, contactName);
					insertStmt.setInt(3, searchRs.getInt("user_id"));
					int rowsInserted = insertStmt.executeUpdate();
					
					// If insert successful, return true.
					if (rowsInserted > 0) {
						return true;
					}
				}
			}
			return false;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
