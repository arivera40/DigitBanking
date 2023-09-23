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
					contact.setPhoneNumber(rs.getString("phone_number"));
					contact.setEmail(rs.getString("email"));
					contacts.add(contact);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		
		return contacts;
	}
}
