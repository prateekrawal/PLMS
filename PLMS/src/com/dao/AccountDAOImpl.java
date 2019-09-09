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
	@Override
	public int addAccountDetails(Account account,User user) {
		// TODO Auto-generated method stub 
		int rows_inserted=0;
		List<Long> accountNo_curr=new ArrayList<>();
		accountNo_curr.add(account.getAccountNo_EURO());
		accountNo_curr.add(account.getAccountNo_GBP());
		accountNo_curr.add(account.getAccountNo_USD());
		
		List<Double> account_openingBalance= new ArrayList<>();
		account_openingBalance.add(account.getOpeningBalance_EURO());
		account_openingBalance.add(account.getOpeningBalance_GBP());
		account_openingBalance.add(account.getOpeningBalance_USD());
		
		List<String> curr_type=new ArrayList<>();
		curr_type.add("EUR");
		curr_type.add("GBP");
		curr_type.add("USD");
		
		try {		
			for(int i=0;i<3;i++) {
			String INSERT_ACCOUNT_DETAILS="insert into Account values(?,?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(INSERT_ACCOUNT_DETAILS);
			ps.setLong(1, accountNo_curr.get(i));
			ps.setString(2,curr_type.get(i));
			ps.setDouble(3, account_openingBalance.get(i));
			ps.setInt(4, user.getUserId());
		    rows_inserted=ps.executeUpdate();
			System.out.println("Rows:" + rows_inserted);
		}
		}
			catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return  rows_inserted;
}
}


