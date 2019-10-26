package com.dao.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection openConnection() throws SQLException {
	 return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "pl_mmt", "plm1234");
	}

}