package com.pojo;
 
public class MoneyMarket 
{
	private String lendBorrow;
	private String txnDate;
	private String dueDate;
	private int marketId;
	private double amount_USD;
	private double amount_EURO;
	private double amount_GBP;
	private int transactionId;
	public String getLendBorrow() {
		return lendBorrow;
	}
	public void setLendBorrow(String lendBorrow) {
		this.lendBorrow = lendBorrow;
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
 