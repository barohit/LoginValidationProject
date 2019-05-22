package com.rrb.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

public class SQLMethods {

	public Connection getConnection() throws Exception {
		try {
			String driver = "com.mysql.jdbc.Driver"; 
			String url = "jdbc:mysql://localhost:3306/loginvalidationproject";
			String username = "loginProjectAccount";
			String password = "Passwurd123";
			Class.forName(driver);
			
			Connection conn = DriverManager.getConnection(url,username,password); 
			System.out.println("Connected");
			return conn;
			
		}  catch (Exception e) {
			System.out.println("Sorry, connection not found"); 
		}
		return null; 
	}
	
	public HashMap<String, String> selectFromUsers() throws Exception {
		HashMap<String, String> userbase = new HashMap<String, String>(); 
		try {
			Connection conn = getConnection();
			PreparedStatement statement = conn.prepareStatement("SELECT username,password FROM userbase"); 
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				userbase.put(result.getString("username"), result.getString("password")); 
			}
			
		} catch (Exception e) {
			System.out.println("Sorry, access denied"); 
		} finally  {
			System.out.println("Function complete"); 
		}
		return userbase; 
	}
}
