package com.pojo;

public class Account {
//	protected String currencyType;
//	protected float balance;
	private static double openingBalance_EURO = 0;
	private static double openingBalance_USD = 0;
	private static double openingBalance_GBP = 0;

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

}