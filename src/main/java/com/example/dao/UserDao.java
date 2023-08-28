package com.example.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.models.User;
import com.example.util.DatabaseConnection;

public class UserDao {
	private Connection connection;
	
	public UserDao() {
		try {
			this.connection = DatabaseConnection.getConnection();
		} catch (SQLException e) {
			throw new RuntimeException("Error initializing UserDao", e);
		}
	}
	
	public User loginUserByEmail(String email, String password) {
		String query = "SELECT * FROM users WHERE email = ? AND password = ?";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, email);
			stmt.setString(2, password);
			
			try (ResultSet rs = stmt.executeQuery()) {
				if (rs.next()) {
					User user = new User();
					user.setUserId(rs.getInt("user_id"));
					user.setFirstName(rs.getString("first_name"));
					user.setLastName(rs.getString("last_name"));
					user.setEmail(rs.getString("email"));
					user.setPhoneNumber(rs.getString("phone_number"));
					user.setPassword(rs.getString("password"));
					return user;
				} else {
					return null;
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
//	public User loginUserByPhone(String phoneNumber, String password) {
//		
//	}
	
	public boolean registerUser(User user) {
		String query = "INSERT INTO users (first_name, last_name, email, phone_number, password) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement stmt = connection.prepareStatement(query)) {
			stmt.setString(1, user.getFirstName());
			stmt.setString(2, user.getLastName());
			stmt.setString(3, user.getEmail());
			stmt.setString(4, user.getPhoneNumber());
			stmt.setString(5, user.getPassword());
			int rowsInserted = stmt.executeUpdate();
			return rowsInserted > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
}
