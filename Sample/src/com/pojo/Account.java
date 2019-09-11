package com.pojo;

public class Account {
//	protected String currencyType;
//	protected float balance;
	private static double openingBalance_EURO = 0;
	private static double openingBalance_USD = 0;
	private static double openingBalance_GBP = 0;

	public double getOpeningBalance_EURO() {
		return Account.openingBalance_EURO;
	}

	public void setOpeningBalance_EURO(double openingBalance_EURO) {
		Account.openingBalance_EURO = openingBalance_EURO;
	}

	public double getOpeningBalance_USD() {
		return Account.openingBalance_USD;
	}

	public void setOpeningBalance_USD(double openingBalance_USD) {
		Account.openingBalance_USD = openingBalance_USD;
	}

	public double getOpeningBalance_GBP() {
		return Account.openingBalance_GBP;
	}

	public void setOpeningBalance_GBP(double openingBalance_GBP) {
		Account.openingBalance_GBP = openingBalance_GBP;
	}

}