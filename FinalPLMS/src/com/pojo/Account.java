package com.pojo;

public class Account {
//	protected String currencyType;
//	protected float balance;
	private long AccountNo_USD;
	private long AccountNo_EURO;
	private long AccountNo_GBP;
	private double openingBalance_EURO;
	private double openingBalance_USD;
	private double openingBalance_GBP;

	public Account(long accountNo_USD, long accountNo_EURO, long accountNo_GBP, double openingBalance_EURO,
			double openingBalance_USD, double openingBalance_GBP) {
		super();
		AccountNo_USD = accountNo_USD;
		AccountNo_EURO = accountNo_EURO;
		AccountNo_GBP = accountNo_GBP;
		this.openingBalance_EURO = openingBalance_EURO;
		this.openingBalance_USD = openingBalance_USD;
		this.openingBalance_GBP = openingBalance_GBP;
	}

	public double getOpeningBalance_EURO() {
		return openingBalance_EURO;
	}

	public void setOpeningBalance_EURO(double openingBalance_EURO) {
		this.openingBalance_EURO = openingBalance_EURO;
	}

	public double getOpeningBalance_USD() {
		return openingBalance_USD;
	}

	public void setOpeningBalance_USD(double openingBalance_USD) {
		this.openingBalance_USD = openingBalance_USD;
	}

	public double getOpeningBalance_GBP() {
		return openingBalance_GBP;
	}

	public void setOpeningBalance_GBP(double openingBalance_GBP) {
		this.openingBalance_GBP = openingBalance_GBP;
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