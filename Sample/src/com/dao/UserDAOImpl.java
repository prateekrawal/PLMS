package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pojo.User;

public class UserDAOImpl implements UserDAO {

	JdbcConnection JC = new JdbcConnection();
	Connection con = JC.openConnection();

	@Override
	public int addUser(User user) {
		// TODO Auto-generated method stub
		int rows_inserted = 0;
//		System.out.println("hai");
		try {
			String INSERT_USER = "insert into User_Details values(?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(INSERT_USER);
			ps.setLong(1, user.getUserId());
			ps.setString(2, user.getUsername());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getFirstName());
			ps.setString(5, user.getLastName());
			ps.setString(6, user.getMailId());
			ps.setString(7, user.getPhoneNo());
			ps.setString(8, user.getCountry());
			ps.setLong(9, user.getAccountNo_EURO());
			ps.setLong(10, user.getAccountNo_GBP());
			ps.setLong(11, user.getAccountNo_USD());

			rows_inserted = ps.executeUpdate();
//			System.out.println("Rows:" + rows_inserted);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return rows_inserted;
	}

}