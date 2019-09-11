package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.pojo.User;
import com.dao.util.SQLQueryUtil;
import com.dao.util.ConnectionUtil;

public class UserDAOImpl implements UserDAO{

	@Override
	public int retriveUserId() throws SQLException {
		int id = 0;
		Connection conn1 = ConnectionUtil.	openConnection();
		PreparedStatement ps = conn1.prepareStatement(SQLQueryUtil.SQL_FIND_LAST_UID);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			id = rs.getInt(1);
		}
		conn1.close();
		return id+1;
	}
	@Override
	public int addUser(User u) throws SQLException {
		
		int rows_inserted = 0;
		Connection conn = ConnectionUtil.	openConnection();
		PreparedStatement ps = conn.prepareStatement(SQLQueryUtil.SQL_INSERT_USER);
		ps.setInt(1, retriveUserId());
		ps.setString(2, u.getUsername());
		ps.setString(3, u.getPassword());
		ps.setString(4, u.getFirstName());
		ps.setString(5, u.getLastName());
		ps.setString(6, u.getMailId());
		ps.setString(7, u.getPhoneNo());
		rows_inserted = ps.executeUpdate();
		System.out.println(rows_inserted);
		conn.close();
		return rows_inserted;
	}
	@Override
	public boolean validateUser(String name, String pwd) throws SQLException {
		boolean status = false;
		Connection conn = ConnectionUtil.	openConnection();
		PreparedStatement ps = conn.prepareStatement(SQLQueryUtil.SQL_GET_USER);
		ps.setString(1, name);
		ps.setString(2, pwd);
		
		ResultSet rs = ps.executeQuery();
		status= rs.next();
		
		return status;
	}
}
