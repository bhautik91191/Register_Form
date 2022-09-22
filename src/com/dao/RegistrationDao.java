package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.RegistrationModel;
import com.util.DBUtil;

/**
* Get Connection 
* Insertdata in Database
* ExecuteUpdate and return Integer value
* 
* @author  Bhautik Padmani
* @version 1.8
* @since   March 2014 
*/
public class RegistrationDao {

	Connection connection = null;
	int executeUpdate = 0;

	public int doRegistration(RegistrationModel registerModel) throws SQLException {
		connection = new DBUtil().getConnectionData(); // Get Connection

		String query = "INSERT INTO employee(first_name, last_name, user_name, password, address, contactno) VALUES(?, ?, ?, ?, ?, ?)";

		try {
			// PreparedStatement to query execute
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, registerModel.getFirstname());
			preparedStatement.setString(2, registerModel.getLastname());
			preparedStatement.setString(3, registerModel.getUsername());
			preparedStatement.setString(4, registerModel.getPassword());
			preparedStatement.setString(5, registerModel.getAddress());
			preparedStatement.setString(6, registerModel.getContactno());

			executeUpdate = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			connection.close();
		}
		return executeUpdate;
	}

}
