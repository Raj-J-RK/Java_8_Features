package com.rk.java8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnectionExample {

	public static void main(String[] args) {
		
		Connection connection = null;
		//Connecting to Oracle 18C DB
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "C##rk_db_user", "******");
				if(null!=connection.getSchema()) {
					System.out.println("DB Connection extablished");
				}
			} catch (SQLException e) {
				System.out.println("Error in Connection"+e);
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
