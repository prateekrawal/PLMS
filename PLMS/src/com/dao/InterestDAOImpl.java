package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.logic.RandomRateGenerator;
import com.pojo.Rates;
import com.pojo.Transaction;

public class InterestDAOImpl implements InterestDAO{
	Connection con=null;
	public int addInterest(Rates rate)
	{
		JdbcConnection JC=new JdbcConnection();
		con=JC.openConnection();
		
			System.out.println("entering Interest IMPL");
			int rows_inserted=0;
			PreparedStatement ps=null;
			//Txn_Id , acc_no, debit or credit, amount , timestamp;
			try {	
				for(int i=0;i<3;i++)
				{
					String INSERT_Interest="insert into interest_rate values(?,?,?,?)"; 
					ps=con.prepareStatement(INSERT_Interest);
					if(i==0)
					{  System.out.println("rate.EURO_IR_ASK"+rate.EURO_IR_ASK);
						ps.setDouble(1, rate.EURO_IR_ASK);
						ps.setDouble(2, rate.EURO_IR_BID);
						ps.setString(3, "EURO");
						
					}
					else if(i==1)
					{
						ps.setDouble(1, rate.GBP_IR_ASK);
						ps.setDouble(2, rate.GBP_IR_BID);
						ps.setString(3, "GBP");
					}
					else
					{
						ps.setDouble(1, rate.USD_IR_ASK);
						ps.setDouble(2, rate.USD_IR_BID);
						ps.setString(3, "USD");
					}
					ps.setString(4,rate.date);
					ps.addBatch();
					ps.executeBatch();
//					con.close();
				}
				
				System.out.println("success");
//			
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			finally
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		return 0;
		
	}

	
	
}
