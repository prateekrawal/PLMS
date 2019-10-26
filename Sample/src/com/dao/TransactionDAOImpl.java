package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.Transaction;

public class TransactionDAOImpl implements TransactionDAO {
	JdbcConnection JC = new JdbcConnection();

	@Override
	public int addTransaction(ArrayList<Transaction> t_AL, String date, String accno) {
		// TODO Auto-generated method stub
		System.out.println("entering txnDAO IMPL");
		int rows_inserted = 0;
		// Txn_Id , acc_no, debit or credit, amount , timestamp;
		try {
			Connection con = JC.openConnection();

			PreparedStatement stmt=null;
			for (int i = 0; i < t_AL.size(); i++) {

				String INSERT_CASHFLOW = "insert into transaction values(?,?,?,?,?)";
				stmt = con.prepareStatement(INSERT_CASHFLOW);
//			System.out.println("inside for loop : " + t_AL.get(i).getTransactionId());
				stmt.setInt(1, t_AL.get(i).getTransactionId());
//			ps.setLong(2, acc_no);
				// ps.setChar(3, t_AL.get(i).getDebitCredit());
				stmt.setString(2, String.valueOf(t_AL.get(i).getDebitCredit()));
				// String.valueOf(myChar))
//			System.out.println("before 3");
				stmt.setDouble(3, t_AL.get(i).getAmount());
//			System.out.println(date);

				stmt.setString(4, date);
				stmt.setString(5, accno);
				System.out.println("Before update");
				
				int row=stmt.executeUpdate();
//				
//				stmt.close();
				System.out.println("i:"+i);
			}

//			stmt.executeBatch();
			//stmt.clearBatch();
			stmt.close();
		//	stmt.executeBatch();
			con.commit();
			System.out.println("success");
		
			con.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rows_inserted;
	}

}