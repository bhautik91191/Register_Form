package com.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.model.RegistrationModel;
import com.util.DBUtil;

/**
* Get Connection 
* Create editUser method and return model
* Create select Querie and get data to set model
* ExecuteUpdate and return model
* Create doUpdateUser method
* Create Update Querie
* 
* @author  Bhautik Padmani
* @version 1.8
* @since   March 2014 
*/
public class HomeDao {

	Connection connection = null;
	RegistrationModel registrationModel = null;

	public RegistrationModel editUser(int userId) throws Exception {
		connection = new DBUtil().getConnectionData(); // Connection Database

		String query = "SELECT * FROM employee WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				registrationModel = new RegistrationModel();
				registrationModel.setId(resultSet.getInt(1));
				registrationModel.setFirstname(resultSet.getString("first_name"));
				registrationModel.setLastname(resultSet.getString("last_name"));
				registrationModel.setUsername(resultSet.getString("user_name"));
				registrationModel.setPassword(resultSet.getString("password"));
				registrationModel.setAddress(resultSet.getString("address"));
				registrationModel.setContactno(resultSet.getString("contactno"));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			connection.close();
		}
		return registrationModel;
	}

	int executeUpdate = 0;

	public int doUpdateUser(RegistrationModel updateModel) throws Exception { 
		connection = new DBUtil().getConnectionData(); // Connection Database

		String query = "UPDATE employee SET first_name=?, last_name=?, user_name=?, password=?, address=?, contactno=? WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, updateModel.getFirstname());
			preparedStatement.setString(2, updateModel.getLastname());
			preparedStatement.setString(3, updateModel.getUsername());
			preparedStatement.setString(4, updateModel.getPassword());
			preparedStatement.setString(5, updateModel.getAddress());
			preparedStatement.setString(6, updateModel.getContactno());
			preparedStatement.setInt(7, updateModel.getId());

			executeUpdate = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			connection.close();
		}
		return executeUpdate;
	}

	public int doDeleteUser(int userId) throws Exception {
		executeUpdate = 0;
		connection = new DBUtil().getConnectionData(); // Connection Database

		String query = "DELETE FROM employee WHERE id=?";

		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userId);

			executeUpdate = preparedStatement.executeUpdate();
		} catch (Exception exception) {
			exception.printStackTrace();
		} finally {
			connection.close();
		}
		return executeUpdate;
	}

}
