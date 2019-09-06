package com.pojo;
 
public class Account 
{
	protected String currencyType;
	protected float balance;
	private long AccountNo_USD=123345;
	private long AccountNo_EURO=12346;
	private long AccountNo_GBP=12347;
	private double openingBalance;
	
	public void setOpeningBalance(double openingBalance) {
		this.openingBalance = openingBalance;
	}
	public long getAccountNo_USD() {
		return AccountNo_USD;
	}
	public void setAccountNo_USD(long accountNo_USD) {
		AccountNo_USD = accountNo_USD;
	}
	public long getAccountNo_EURO() {
		return AccountNo_EURO;
	}
	public void setAccountNo_EURO(long accountNo_EURO) {
		AccountNo_EURO = accountNo_EURO;
	}
	public long getAccountNo_GBP() {
		return AccountNo_GBP;
	}
	public void setAccountNo_GBP(long accountNo_GBP) {
		AccountNo_GBP = accountNo_GBP;
	}
	
}