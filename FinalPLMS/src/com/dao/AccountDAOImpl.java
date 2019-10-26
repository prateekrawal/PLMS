package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dao.util.ConnectionUtil;
import com.dao.util.SQLQueryUtil;
import com.pojo.Account;
public class AccountDAOImpl implements AccountDAO{

	@Override
	public List<Long> retriveAccountNumber() throws SQLException {
		// TODO Auto-generated method stub
		List<Long> l = new ArrayList();
		Connection conn1 = ConnectionUtil.openConnection();
		PreparedStatement ps = conn1.prepareStatement(SQLQueryUtil.SQL_GET_AC_NO);
		ResultSet rs = ps.executeQuery();
	//	l.add((long) 1561);
	//	l.add((long)1222);
	//	l.add((long)2222);
	
		System.out.println("summa");
		while(rs.next()) {
			System.out.println("summa");
			String curr_type = rs.getString(1);
			long acc_no = rs.getLong(2);
			l.add(acc_no+1);
		}
		conn1.close();
		return l;
	}

	@Override
	public int addAccount(Account a, int userid) throws SQLException {
		int first = 0, second = 0, third =0;
		Connection conn = ConnectionUtil.	openConnection();
		PreparedStatement ps = conn.prepareStatement(SQLQueryUtil.SQL_INSERT_ACCOUNT);
		ps.setLong(1, a.getAccountNo_USD());
		ps.setString(2, "USD");
		ps.setDouble(3, a.getOpeningBalance_USD());
		ps.setInt(4, userid);
		first = ps.executeUpdate();
		ps = conn.prepareStatement(SQLQueryUtil.SQL_INSERT_ACCOUNT);
		ps.setLong(1, a.getAccountNo_EURO());
		ps.setString(2, "EUR");
		ps.setDouble(3, a.getOpeningBalance_EURO());
		ps.setInt(4, userid);
		second = ps.executeUpdate();
		ps = conn.prepareStatement(SQLQueryUtil.SQL_INSERT_ACCOUNT);
		ps.setLong(1, a.getAccountNo_GBP());
		ps.setString(2, "GBP");
		ps.setDouble(3, a.getOpeningBalance_GBP());
		ps.setInt(4, userid);
		third = ps.executeUpdate();
		int flag = 0;
		if(first ==1 && second == 1 && third ==1)
			flag=1;
		return flag;
	}

	

}
