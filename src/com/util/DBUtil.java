package com.util;
import java.sql.Connection;
import java.sql.DriverManager;

/**
* Connection Database
* Return Connection
* 
* @author  Bhautik Padmani
* @version 1.8
* @since   March 2014 
*/
public class DBUtil {

	Connection connection = null;

	public Connection getConnectionData() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/register_form", "root", "");
			System.out.println("Connection Established...");
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return connection;
	}

}