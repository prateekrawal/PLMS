package com.pojo;

public class MoneyMarket {
	private static char lendBorrow;
	private static String txnDate;
	private static String dueDate;
	private int marketId;
	private static double amount_USD = 5200;
	private static double amount_EURO = 9000;
	private static double amount_GBP = -6700;
	private int transactionId;
	private static double EURO_Base;
	private static double GBP_Base;
	private static double USD_Base;
	private static double interest;
public static long account;
	public static long getAccount() {
	return account;
}

public static void setAccount(long account) {
	MoneyMarket.account = account;
}

	public static double getInterest() {
		return interest;
	}

	public static void setInterest(double interest) {
		MoneyMarket.interest = interest;
	}

	
	public double getEURO_Base() {
		return EURO_Base;
	}

	public void setEURO_Base(double eURO_Base) {
		EURO_Base = eURO_Base;
	}

	public double getGBP_Base() {
		return GBP_Base;
	}

	public void setGBP_Base(double gBP_Base) {
		GBP_Base = gBP_Base;
	}

	public double getUSD_Base() {
		return USD_Base;
	}

	public void setUSD_Base(double uSD_Base) {
		USD_Base = uSD_Base;
	}

	public char getLendBorrow() {
		return lendBorrow;
	}

	public void setLendBorrow( char lb) {
		this.lendBorrow = lb;
	}

	public String getTxnDate() {
		return txnDate;
	}

	public void setTxnDate(String txnDate) {
		this.txnDate = txnDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public int getMarketId() {
		return marketId;
	}

	public void setMarketId(int marketId) {
		this.marketId = marketId;
	}

	public double getAmount_USD() {
		return amount_USD;
	}

	public void setAmount_USD(double amount_USD) {
		this.amount_USD = amount_USD;
	}

	public double getAmount_EURO() {
		return amount_EURO;
	}

	public void setAmount_EURO(double amount_EURO) {
		this.amount_EURO = amount_EURO;
	}

	public double getAmount_GBP() {
		return amount_GBP;
	}

	public void setAmount_GBP(double amount_GBP) {
		this.amount_GBP = amount_GBP;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}
