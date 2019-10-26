package com.logic;

import java.util.ArrayList;
import java.util.Scanner;

import com.dao.TransactionDAOImpl;
import com.pojo.Account;
import com.pojo.MoneyMarket;
import com.pojo.Rates;
import com.pojo.Transaction;
import com.pojo.User;

public class Market {

//	double openbal=50000000;    //opening bal to be fetched from dao marketclass
//	double total=openbal;           //total to be stored back in DB via market class          

	Account account = new Account();
	ArrayList<Transaction> t_AL_USD = new ArrayList<Transaction>();
	ArrayList<Transaction> t_AL_EURO = new ArrayList<Transaction>();
	ArrayList<Transaction> t_AL_GBP = new ArrayList<Transaction>();

	MoneyMarket moneymarket = new MoneyMarket();

	Rates rate = new Rates();
	Account acc = new Account();
	User user = new User();	
	Transaction t=new Transaction();
	TransactionDAOImpl tdao=new TransactionDAOImpl();
	public void userCashflow()
	{
		ArrayList<Transaction>t_AL=new ArrayList<Transaction>();
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter debit or credit (D/C)");
		t.setDebitCredit(sc.next().charAt(0));
		System.out.println("Enter the amount");
		t.setAmount(sc.nextDouble());
		t.setTransactionId(++App.TID_Counter);
		
		t_AL.add(t);
		System.out.println("Enter the account type (e/g/u):");
		char c=sc.next().charAt(0);
		
		if(c=='e')
			tdao.addTransaction(t_AL,App.date,String.valueOf(user.getAccountNo_EURO()));
		else if(c=='g')
			tdao.addTransaction(t_AL,App.date,String.valueOf(user.getAccountNo_GBP()));
		else
			tdao.addTransaction(t_AL,App.date,String.valueOf(user.getAccountNo_USD()));
		
		updateBal(t_AL,c);
	}
	
	public void updateBal(ArrayList<Transaction> t_AL,char c)
	{
		Market market = new Market();
		if(c=='e')
		moneymarket.setAmount_EURO(market.cal_netBal(t_AL, moneymarket.getAmount_EURO()));
		else if(c=='u')
		moneymarket.setAmount_USD(market.cal_netBal(t_AL, moneymarket.getAmount_USD()));
		else 
		moneymarket.setAmount_GBP(market.cal_netBal(t_AL, moneymarket.getAmount_GBP()));

	}
	
	public void updateOpeningBal()
	{
		acc.setOpeningBalance_EURO(acc.getOpeningBalance_EURO()+moneymarket.getAmount_EURO());
		acc.setOpeningBalance_GBP(acc.getOpeningBalance_GBP()+moneymarket.getAmount_GBP());
		acc.setOpeningBalance_USD(acc.getOpeningBalance_USD()+moneymarket.getAmount_USD());
		
	
	}
	
	public void start() {
		RandomCashFlowGenerator RCG = new RandomCashFlowGenerator();
		Market market = new Market();
		RCG.generateDate();

	
		rate.date = App.date;
		
		int cnt=0;
		cnt = (int) (((Math.random() * ((10 - 1)))) + 30);

		t_AL_EURO = RCG.generateCashflow(user.getAccountNo_EURO(), App.date,cnt); // cashflow func to be called in trigger class
		cnt = (int) (((Math.random() * ((10 - 1)))) + 30);

		t_AL_GBP = RCG.generateCashflow(user.getAccountNo_GBP(), App.date,cnt); // cashflow func to be called in trigger class
		cnt = (int) (((Math.random() * ((10 - 1)))) + 30);

		t_AL_USD = RCG.generateCashflow(user.getAccountNo_USD(), App.date,cnt); // cashflow func to be called in trigger class

		moneymarket.setAmount_USD(market.cal_netBal(t_AL_USD, moneymarket.getAmount_USD()));
		moneymarket.setAmount_EURO(market.cal_netBal(t_AL_EURO, moneymarket.getAmount_EURO()));
		moneymarket.setAmount_GBP(market.cal_netBal(t_AL_GBP, moneymarket.getAmount_GBP()));

		moneymarket.setEURO_Base(cal_netBaseEURO());
		moneymarket.setGBP_Base(cal_netBaseGBP());
		moneymarket.setUSD_Base(cal_netBaseUSD());
//		System.out.println("DATE:"+ App.counter+"/"+App.month+"/19");
//				t.setTimestamp(sd);
//		System.out.println("Euro : "+EURO_Base+" GBP : "+GBP_Base+" USD : "+USD_Base);
	}

	public void display_EOLBal_In_Base() {
		System.out.printf("EUR : %.4f\n", moneymarket.getEURO_Base());
		System.out.printf("GBP : %.4f\n", moneymarket.getGBP_Base());
		System.out.printf("USD : %.4f\n", moneymarket.getUSD_Base());

	}

	public void display_EOLBal() {
		System.out.println("End of day balane in accounts:");
		System.out.printf("%.4f\n", moneymarket.getAmount_EURO());
		System.out.printf("%.4f\n", moneymarket.getAmount_GBP());
		System.out.printf("%.4f\n", moneymarket.getAmount_USD());

	}

	public double cal_netBal(ArrayList<Transaction> arr, double openbal) {
//		openbal=50000000;    //opening bal to be fetched from dao marketclass

		double total = openbal; // total to be stored back in DB via market class
		for (int i = 0; i < arr.size(); i++) {
			if (arr.get(i).getDebitCredit() == 'D')
				total = total - arr.get(i).getAmount();
			else if((arr.get(i).getDebitCredit() == 'C'))
				total = total + arr.get(i).getAmount();

		}

		return total;
	}

	public double cal_netBaseEURO() {
		double EURO_Base = moneymarket.getAmount_EURO();

		if (moneymarket.getAmount_USD() > 0)
			EURO_Base = EURO_Base + (moneymarket.getAmount_USD() / Rates.EUR_USD_ASK);
		else
			EURO_Base = EURO_Base + (moneymarket.getAmount_USD() / Rates.EUR_USD_BID);

		if (moneymarket.getAmount_GBP() > 0)
			EURO_Base = EURO_Base + (moneymarket.getAmount_GBP() / Rates.EUR_GBP_ASK);
		else
			EURO_Base = EURO_Base + (moneymarket.getAmount_GBP() / Rates.EUR_GBP_BID);

		return EURO_Base;
	}

	public double cal_netBaseGBP() {
		double GBP_Base = moneymarket.getAmount_GBP();
		if (moneymarket.getAmount_USD() > 0)
			GBP_Base = GBP_Base + (moneymarket.getAmount_USD() / Rates.GBP_USD_ASK);
		else
			GBP_Base = GBP_Base + (moneymarket.getAmount_USD() / Rates.GBP_USD_BID);

		if (moneymarket.getAmount_EURO() > 0)
			GBP_Base = GBP_Base + (moneymarket.getAmount_EURO() * Rates.EUR_GBP_BID);
		else
			GBP_Base = GBP_Base + (moneymarket.getAmount_EURO() * Rates.EUR_GBP_ASK);

		return GBP_Base;
	}

	public double cal_netBaseUSD() {
		double USD_Base = moneymarket.getAmount_USD();
		if (moneymarket.getAmount_GBP() > 0)
			USD_Base = USD_Base + (moneymarket.getAmount_GBP() * Rates.GBP_USD_BID);
		else
			USD_Base = USD_Base + (moneymarket.getAmount_GBP() * Rates.GBP_USD_ASK);

		if (moneymarket.getAmount_EURO() > 0)
			USD_Base = USD_Base + (moneymarket.getAmount_EURO() * Rates.EUR_USD_BID);
		else
			USD_Base = USD_Base + (moneymarket.getAmount_EURO() * Rates.EUR_USD_ASK);

		return USD_Base;
	}
}
