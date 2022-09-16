package com.qa.database.automation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import org.testng.annotations.Test;

public class DB_Test extends Base{
	@Test
	public void getTableData() throws SQLException {
		connection = this.setUp();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery("select * from Student");
		while(resultSet.next()) {
			String User_Id = resultSet.getString(1);
			String User_Name = resultSet.getString(2);
			String User_Email = resultSet.getString(3);
			System.out.println(User_Id +" "+ User_Name+" "+User_Email);
		}
	}
	
	@Test
	public void insertData() throws SQLException {
		connection = this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("insert into Student(User_Id, User_Name, User_Email)values(?,?,?)");
		preparedStatement.setString(1, "4");
		preparedStatement.setString(2, "Sneha");
		preparedStatement.setString(3, "sneha@gmail.com");
		preparedStatement.executeUpdate();
		getTableData();
	}
	
	@Test
	public void deleteData() throws SQLException {
		connection =this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("delete from Student where User_Name = 'Ammy Raikwar' ");
		preparedStatement.executeUpdate();
		getTableData();
	}
	
	@Test
	public void updateData() throws SQLException {
		connection = this.setUp();
		PreparedStatement preparedStatement = connection.prepareStatement("update Student set User_Id = 1 where User_Name = 'Aniket Raikwar'");
		preparedStatement.executeUpdate();
		getTableData();
	}
	

}
