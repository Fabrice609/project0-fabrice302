package com.revature.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {

	/*a singleton design pattern only allows only 
	One instance of  a class to exist in memory at a time
	*/
	private static Connection connection;
	
	public static Connection getConnection() throws SQLException { 
	
		//my method that allows me to get a connection off the utility class
		
		if(connection!=null && !connection.isClosed()) {
			return connection;
			}else {
				/*for many frameworks, or in cases where there are multiple SQL drivers, 
				you will need to register which driver you are using for the connection interface. The class.forName method
				will allow you to do this. 
				This step is often unnesscary for simple projects but is considered best practice.
				*/
				
				try {
						Class.forName("org.postgresql.Driver");
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				
				String url ="jdbc:postgresql://javafs609410.c9k17epeqkau.us-east-1.rds.amazonaws.com:5432/postgres";
				String username = "postgres"; 
				 String password = "password";
				 /*it is possible to hide raw credentials by using ENV variables
				 you can access those variables with System.getenv("var-name");
				  */
				
				 connection =  DriverManager.getConnection(url, username, password);
				 
				 return connection;
				 
				}
		}

	public static void main(String[] args) {
		try {
			getConnection();
			System.out.println("Connection was Successful Fab!");
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}

