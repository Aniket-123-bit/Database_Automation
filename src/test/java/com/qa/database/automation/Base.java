package com.qa.database.automation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class Base {
public static Connection connection;
	
	@BeforeTest
	public Connection setUp() throws SQLException {
	String durl = "jdbc:mysql://localhost:3306/database_automation";
	String username = "root";
	String password = "Aniket@123";
	connection = DriverManager.getConnection(durl, username, password);
	return connection;
	}
	
	@AfterTest
	public void tearDown() throws SQLException {
		connection.close();
	}

}
