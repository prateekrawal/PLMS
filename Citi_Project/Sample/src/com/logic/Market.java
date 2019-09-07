package com.logic;

import java.util.ArrayList;

import com.pojo.Account;
import com.pojo.MoneyMarket;
import com.pojo.Transaction;

public class Market {

	double openbal=50000000;    //opening bal to be fetched from dao marketclass
	double total=openbal;           //total to be stored back in DB via market class          

	Account account=new Account();
	ArrayList<Transaction>t_AL_USD=new ArrayList<Transaction>();
	ArrayList<Transaction>t_AL_EURO=new ArrayList<Transaction>();
	ArrayList<Transaction>t_AL_GBP=new ArrayList<Transaction>();
	
	
	
	public void start()
	{
		RandomCashFlowGenerator RCG=new RandomCashFlowGenerator();
		t_AL_USD=RCG.generateCashflow(account.getAccountNo_EURO());      //cashflow func to be called in trigger class
		t_AL_EURO=RCG.generateCashflow(account.getAccountNo_EURO());      //cashflow func to be called in trigger class
		t_AL_GBP=RCG.generateCashflow(account.getAccountNo_EURO());      //cashflow func to be called in trigger class
		
		MoneyMarket moneymarket=new MoneyMarket();
		Market market =new Market();
		moneymarket.setAmount_USD(market.cal_netBal(t_AL_USD,account.getAccountNo_USD()));
		moneymarket.setAmount_EURO(market.cal_netBal(t_AL_EURO,account.getAccountNo_EURO()));
		moneymarket.setAmount_GBP(market.cal_netBal(t_AL_GBP,account.getAccountNo_GBP()));
		
	}
	
	public double cal_netBal(ArrayList<Transaction> arr,long accno)
	{
		for(int i=0;i<arr.size();i++)
		{
			if(arr.get(i).getDebitCredit()=='D')
				total=total-arr.get(i).getAmount();
			else
				total=total+arr.get(i).getAmount();
		}

		return total;
	}
	
}
