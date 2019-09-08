package com.logic;

import com.dao.JdbcConnection;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.pojo.User;

public class App {

	public static void main(String [] args)
	{
		
		
		RandomRateGenerator RRG=new RandomRateGenerator();
		RandomCashFlowGenerator RCG=new RandomCashFlowGenerator();
		JdbcConnection JC=new JdbcConnection();
		UserDAO dao=new UserDAOImpl();
		User user=new User(1, "Apurva", "password", "firstName", "lastName", "mailId", "country", "phoneNo", 10, 11, 12);
		
		RRG.IR();
		RRG.FX();
		
		//JC.openConnection();
		dao.addUser(user);
		RCG.generateCashflow();
		
	}
	
}
