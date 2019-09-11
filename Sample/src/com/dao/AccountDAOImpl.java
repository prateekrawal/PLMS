package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Account;
import com.pojo.User;

public class AccountDAOImpl implements AccountDAO{
	JdbcConnection JC=new JdbcConnection();
	Connection con=JC.openConnection();
	User user=new User();
	@Override
	public int addAccountDetails(Account account,User user) {
		// TODO Auto-generated method stub 
		int rows_inserted=0;
		List<Long> accountNo_curr=new ArrayList<>();
		accountNo_curr.add(user.getAccountNo_EURO());
		accountNo_curr.add(user.getAccountNo_GBP());
		accountNo_curr.add(user.getAccountNo_USD());
		
		List<Double> account_openingBalance= new ArrayList<>();
		account_openingBalance.add(account.getOpeningBalance_EURO());
		account_openingBalance.add(account.getOpeningBalance_GBP());
		account_openingBalance.add(account.getOpeningBalance_USD());
		
		List<String> curr_type=new ArrayList<>();
		curr_type.add("EUR");
		curr_type.add("GBP");
		curr_type.add("USD");
		PreparedStatement ps=null;
		try {	
			Connection con=JC.openConnection();
			
			for(int i=0;i<3;i++) {
				String INSERT_ACCOUNT_DETAILS="insert into Account values(?,?,?,?)"; 
			ps=con.prepareStatement(INSERT_ACCOUNT_DETAILS);
			ps.setLong(1, accountNo_curr.get(i));
			ps.setString(2,curr_type.get(i));
			ps.setDouble(3, account_openingBalance.get(i));
			ps.setInt(4, user.getUserId());
		   //			con.close();
			ps.addBatch(INSERT_ACCOUNT_DETAILS);
			}
			
//			 rows_inserted=ps.executeUpdate();
			ps.executeBatch();
				System.out.println("Rows:" + rows_inserted);
				con.close();
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return  rows_inserted;
}
}