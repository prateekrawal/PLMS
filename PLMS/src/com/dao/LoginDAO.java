package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginDAO {
	public String doLogin(String username,String password) {
		JdbcConnection JC=new JdbcConnection();
		Connection con=JC.openConnection();
		String name="no user";
		String SQL_LOGIN=
				"select username,password from user_details where username=? and password=?";
			try {
					PreparedStatement ps=con.prepareStatement(SQL_LOGIN);
					ps.setString(1, username);
					ps.setString(2, password);
					ResultSet rs=ps.executeQuery();
					while(rs.next()) {
						name=rs.getString(2);
						if(name.equals(username))
						{
							return username;
						}
					}
			}
			
			catch(Exception e) {
				e.printStackTrace();
			}
			return name;
			
	}
}
