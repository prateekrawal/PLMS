package com.logic;

import java.util.ArrayList;

import com.pojo.Account;
import com.pojo.Transaction;

public class Dashboard {

	
	//if trigger pressed Trigger()
	public void start() 
	{
	Trigger trigger=new Trigger();
	trigger.start();
	
	
	Market market=new Market();
	market.start();
	Account account=new Account();
	ArrayList<Transaction>t_AL_USD=new ArrayList<Transaction>();
	
	RandomCashFlowGenerator RCG=new RandomCashFlowGenerator();
	t_AL_USD=RCG.generateCashflow(account.getAccountNo_EURO());      //cashflow func to be called in trigger class
	
	      // array list not to be sent from here. it will come from dao class in body of this func
	}
}
