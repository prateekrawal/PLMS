package com.logic;

import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import com.dao.MoneyMarketDAOImpl;
import com.pojo.Account;
import com.pojo.MoneyMarket;
import com.pojo.Rates;
import com.pojo.Transaction;
import com.pojo.User;

public class Interest {

	MoneyMarket mm = new MoneyMarket();
	MoneyMarketDAOImpl mdao=new MoneyMarketDAOImpl();
	User user=new User();
	
	char lb;
	char ctype;
	double IR_EURO;
	double IR_GBP;
	double IR_USD;
	public void start() {
		IR_EURO = calculateInterest(mm.getEURO_Base(), Rates.getEURO_IR_BID(), Rates.getEURO_IR_ASK());
		System.out.println("interest gained in euro " + IR_EURO);
		double IR_EURO_USD = conversion(mm.getEURO_Base(), IR_EURO, Rates.getEUR_USD_ASK(), Rates.getEUR_USD_BID());
		IR_GBP = calculateInterest(mm.getGBP_Base(), Rates.getGBP_IR_BID(), Rates.getGBP_IR_ASK());
		System.out.println("interest gained in gbp " + IR_GBP);
		double IR_GBP_USD = conversion(mm.getGBP_Base(), IR_GBP, Rates.getGBP_USD_ASK(), Rates.getGBP_USD_BID());
		IR_USD = calculateInterest(mm.getUSD_Base(), Rates.getUSD_IR_BID(), Rates.getUSD_IR_ASK());
		System.out.println("interest gained in usd " + IR_USD);

		compare(IR_EURO_USD, IR_GBP_USD, IR_USD);

		mm.setTxnDate(App.date);
		StringBuilder sd = new StringBuilder();
		sd.append(String.valueOf((App.counter+1)));
		sd.append("/");
		sd.append(App.month);
		sd.append("/19");
		System.out.println(sd);
		String date1 = sd.toString();
		mm.setDueDate(date1);

		mm.setLendBorrow(lb);
		mm.setMarketId(++App.MID_Counter);
		if(ctype=='u')
			{
			mm.setInterest(IR_USD);
			mm.setAccount(user.getAccountNo_USD());
			}
		else if(ctype=='e')
		{
			mm.setInterest(IR_EURO);
			mm.setAccount(user.getAccountNo_EURO());
		}
			else
			{
			mm.setInterest(IR_GBP);
			mm.setAccount(user.getAccountNo_USD());
			}
		
		mdao.addMarketTransaction();
		
		nextDayOpenBal();
		
		
	}

	public void nextDayOpenBal() {
		Account account = new Account();
		if (lb == 'l') {
			if (ctype == 'u')
			{				account.setOpeningBalance_USD(account.getOpeningBalance_USD() + IR_USD);
			System.out.println("look here:"+account.getOpeningBalance_USD());
			}else if (ctype == 'g')
			{
				account.setOpeningBalance_GBP(account.getOpeningBalance_GBP() + IR_GBP);
				System.out.println("look here:"+account.getOpeningBalance_GBP());
				
				
			}else
				account.setOpeningBalance_EURO(account.getOpeningBalance_EURO() + IR_EURO);
			System.out.println("look here:"+account.getOpeningBalance_EURO());
			
		} else {
			if (ctype == 'u')
				{account.setOpeningBalance_USD(account.getOpeningBalance_USD() - IR_USD);
				System.out.println("look here:"+account.getOpeningBalance_USD());
				
				}else if (ctype == 'g')
				{
					account.setOpeningBalance_GBP(account.getOpeningBalance_GBP() - IR_GBP);
					System.out.println("look here:"+account.getOpeningBalance_GBP());
					
				}	else
				{
				account.setOpeningBalance_EURO(account.getOpeningBalance_EURO() - IR_EURO);
				System.out.println("look here:"+account.getOpeningBalance_EURO());
				
				}
				}
		
		account.setOpeningBalance_EURO(account.getOpeningBalance_EURO()+mm.getAmount_EURO());
		account.setOpeningBalance_GBP(account.getOpeningBalance_GBP()+mm.getAmount_GBP());
		account.setOpeningBalance_USD(account.getOpeningBalance_USD()+mm.getAmount_USD());
	}

	public double calculateInterest(double base, float bid, float ask) {

		double IR;
		if (base > 0) {
			IR = base * bid / 36500;

		} else {
			IR = base * ask / 36500;
		}
		return IR;
	}

	public double conversion(double base, double currAmt, float ask, float bid) {
		double temp = 0;
		if (currAmt > 0)
			temp = currAmt * bid;
		else
			temp = currAmt * ask;
		return temp;
	}	
	
	public void compare(double IRe, double IRg, double IRu) 
	{
//		TreeMap<Double,String> TreeMap = new TreeMap<Double,String>();
//		TreeMap.put(IRe, "EURO");
//		TreeMap.put(IRg, "GBP");
//		TreeMap.put(IRu, "USD");
		
//		for (Entry<String, String> entry : TreeMap.entrySet()) {
//		    String key = entry.getKey();
//		    String value = entry.getValue();
//
//		    System.out.printf("%s : %s\n", key, value);
//		}

	
		
		
		if (IRe < 0 && IRg < 0 && IRu < 0) 
		{
			lb = 'b';
			if (IRe >= IRg) 
			{
				if (IRe >= IRu) 
				{
					System.out.printf("\nBorrow in EURO %.4f", Math.abs(IRe));
					//ctype = 'e';
					if(IRu>=IRg)
					{
						System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
						System.out.printf("\nBorrow in GBP %.4f", Math.abs(IRg));
					}
					else
					{
						System.out.printf("\nBorrow in GBP %.4f", Math.abs(IRg));
						System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
					}
				} 
				else 
				{
					System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
					System.out.printf("\nBorrow in EURO %.4f", Math.abs(IRe));
					System.out.printf("\nBorrow in GBP %.4f", Math.abs(IRg));
					//ctype = 'u';
				}
			} 
			else 
			{
				if (IRg >= IRu) 
				{
					System.out.printf("\nBorrow in GBP %.4f", Math.abs(IRg));
					//ctype = 'g';
					if(IRu>=IRe)
					{
						System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
						System.out.printf("\nBorrow in EURO %.4f", Math.abs(IRe));
					}
					else
					{
						System.out.printf("\nBorrow in EURO %.4f", Math.abs(IRe));
						System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
					}
				} 
				else 
				{
					System.out.printf("\nBorrow in USD %.4f", Math.abs(IRu));
					System.out.printf("\nBorrow in GBP %.4f", Math.abs(IRg));
					System.out.printf("\nBorrow in EURO %.4f", Math.abs(IRe));
					//ctype = 'u';
				}
			}
		} 
		else 
		{
			lb = 'l';
			if (IRe >= IRg) 
			{
				if (IRe >= IRu) 
				{
					System.out.printf("\nInvest in EURO %.4f", Math.abs(IRe));
					//ctype = 'e';
					if(IRu>=IRg)
					{
						System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
						System.out.printf("\nInvest in GBP %.4f", Math.abs(IRg));
					}
					else
					{
						System.out.printf("\nInvest in GBP %.4f", Math.abs(IRg));
						System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
					}
				} 
				else 
				{
					System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
					System.out.printf("\nInvest in EURO %.4f", Math.abs(IRe));
					System.out.printf("\nInvest in GBP %.4f", Math.abs(IRg));
					//ctype = 'u';
				}
			} 
			else 
			{
				if (IRg >= IRu) 
				{
					System.out.printf("\nInvest in GBP %.4f", Math.abs(IRg));
					//ctype = 'g';
					if(IRu>=IRe)
					{
						System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
						System.out.printf("\nInvest in EURO %.4f", Math.abs(IRe));
					}
					else
					{
						System.out.printf("\nInvest in EURO %.4f", Math.abs(IRe));
						System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
					}
				} 
				else 
				{
					System.out.printf("\nInvest in USD %.4f", Math.abs(IRu));
					System.out.printf("\nInvest in GBP %.4f", Math.abs(IRg));
					System.out.printf("\nInvest in EURO %.4f", Math.abs(IRe));
					//ctype = 'u';
				}
			}
			
		}
		//write here
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter your investment choice (e/g/u) : ");
		ctype=sc.next().charAt(0);
	}
}
