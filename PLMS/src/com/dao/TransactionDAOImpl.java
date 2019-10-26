package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Transaction;

public class TransactionDAOImpl implements TransactionDAO {
	JdbcConnection JC=new JdbcConnection();
	Connection con=JC.openConnection();
	
	@Override
	public int addTransaction(ArrayList<Transaction> t_AL, long acc_no) {
		// TODO Auto-generated method stub
		System.out.println("entering txnDAO IMPL");
		int rows_inserted=0;
		//Txn_Id , acc_no, debit or credit, amount , timestamp;
		try {		
			for(int i=0;i<t_AL.size();i++) {
			String INSERT_CASHFLOW="insert into transaction values(?,?,?,?,?)"; 
			PreparedStatement ps=con.prepareStatement(INSERT_CASHFLOW);
			System.out.println("inside for loop : " + t_AL.get(i).getTransactionId());
			ps.setInt(1, t_AL.get(i).getTransactionId());
			ps.setLong(2, acc_no);
			ps.setString(3, t_AL.get(i).getDebitCredit());
			ps.setDouble(4, t_AL.get(i).getAmount());
			ps.setTimestamp(5, t_AL.get(i).getTimestamp());
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
