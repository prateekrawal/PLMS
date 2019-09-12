package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.pojo.Rates;

public class FXDAOImpl implements FXDAO
{
	Connection con=null;
	public int addFXRates()
	{
		JdbcConnection JC=new JdbcConnection();
		con=JC.openConnection();
		
			System.out.println("entering rates IMPL");
			int rows_inserted=0;
			Rates rate=new Rates();
			PreparedStatement ps=null;
			//Txn_Id , acc_no, debit or credit, amount , timestamp;
			try {	
				for(int i=0;i<3;i++)
				{
					String INSERT_Rate="insert into fx_rates values(?,?,?,?)"; 
					ps=con.prepareStatement(INSERT_Rate);
					if(i==0)
					{
						ps.setDouble(1, rate.getEUR_USD_ASK());
						ps.setDouble(2, rate.getEUR_USD_BID());
						ps.setString(3, "EURO_USD");
						
					}
					else if(i==1)
					{
						ps.setDouble(1, rate.getEUR_GBP_ASK());
						ps.setDouble(2, rate.getEUR_GBP_BID());
						ps.setString(3, "EURO_GBP");
					}
					else
					{
						ps.setDouble(1, rate.getGBP_USD_ASK());
						ps.setDouble(2, rate.getGBP_USD_BID());
						ps.setString(3, "GBP_USD");
					}
					ps.setString(4,rate.date);
					ps.addBatch();
					ps.executeBatch();
//					con.close();
				}
				ps.clearBatch();
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
