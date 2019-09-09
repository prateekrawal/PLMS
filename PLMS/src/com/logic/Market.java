package com.logic;

import java.util.ArrayList;

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
	User user=new User();
	
	public void start() {
		RandomCashFlowGenerator RCG = new RandomCashFlowGenerator();
	
		RCG.generateDate();
		
		t_AL_EURO = RCG.generateCashflow(user.getAccountNo_EURO()); // cashflow func to be called in trigger class
		t_AL_GBP = RCG.generateCashflow(user.getAccountNo_GBP()); // cashflow func to be called in trigger class
		t_AL_USD = RCG.generateCashflow(user.getAccountNo_USD()); // cashflow func to be called in trigger class

		Market market = new Market();
		moneymarket.setAmount_USD(market.cal_netBal(t_AL_USD, acc.getOpeningBalance_USD()));
		moneymarket.setAmount_EURO(market.cal_netBal(t_AL_EURO, acc.getOpeningBalance_EURO()));
		moneymarket.setAmount_GBP(market.cal_netBal(t_AL_GBP, acc.getOpeningBalance_GBP()));

		moneymarket.setEURO_Base(cal_netBaseEURO());
		moneymarket.setGBP_Base(cal_netBaseGBP());
		moneymarket.setUSD_Base(cal_netBaseUSD());
		System.out.println("DATE:"+ App.counter+"/"+App.month+"/19");
		
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
			else
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
