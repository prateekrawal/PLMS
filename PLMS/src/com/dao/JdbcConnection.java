package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

	public Connection openConnection() {
		Connection con = null;
		try {
//			System.out.println("in class");
			Class.forName("oracle.jdbc.driver.OracleDriver");
//			System.out.println("Driver loaded sucessfully");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pl_mmt", "plm1234");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}