package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.pojo.MoneyMarket;
import com.pojo.Rates;
	
public class MoneyMarketDAOImpl implements MoneyMarketDAO{
	MoneyMarket mm=new MoneyMarket();
	public void addMarketTransaction() {
		
		Connection con=null;
		JdbcConnection JC=new JdbcConnection();
		con=JC.openConnection();
			
		System.out.println("entering moneymarket IMPL");
		int rows_inserted=0;
		Rates rate=new Rates();
		PreparedStatement stmt=null;
				
				try {
		String INSERT_MM = "insert into money_market values(?,?,?,?,?,?)";
		stmt = con.prepareStatement(INSERT_MM);
//	System.out.println("inside for loop : " + t_AL.get(i).getTransactionId());
		stmt.setDouble(1, mm.getInterest());
//	ps.setLong(2, acc_no);
		// ps.setChar(3, t_AL.get(i).getDebitCredit());
		System.out.println(mm.getLendBorrow());
		stmt.setString(2, String.valueOf(mm.getLendBorrow()));
		// String.valueOf(myChar))
//	System.out.println("before 3");
		stmt.setString(3, mm.getTxnDate());
//	System.out.println(date);

		stmt.setString(4, mm.getDueDate());
		stmt.setLong(5, mm.getAccount());
		stmt.setInt(6, mm.getMarketId());
		System.out.println("Before update");
		
		int row=stmt.executeUpdate();
//		
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}
	}
	
	
}
