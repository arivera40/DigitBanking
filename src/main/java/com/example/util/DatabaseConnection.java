package com.example.util;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/digitbanking_schema";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "***REMOVED***";
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // Load the driver class
	        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
		} catch (ClassNotFoundException e) {
	        throw new RuntimeException("Error loading MySQL JDBC driver", e);
		}
	}
}
