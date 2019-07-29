package com.secondstep.skillmatrix.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {

		





	
		String jdbcUrl = "jdbc:mysql://localhost:3306/skill_matrix?useSSL=false&serverTimezone=UTC";
		String user = "skillMatrix";
		String pass = "skillmatrix";
		
		try {
			System.out.println("Connecting to database: " + jdbcUrl);
			
			Connection myConn =
					DriverManager.getConnection(jdbcUrl, user, pass);
						
			System.out.println("Connection successful!!!");
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		
	}


	}

}






