package com.pojo;

public class Rates {


	public  float EURO_IR_BID;
	public  float USD_IR_BID;
	public  float GBP_IR_BID;
	public  float EURO_IR_ASK;
	public  float USD_IR_ASK;
	public  float GBP_IR_ASK;
	
	public  float EUR_USD_BID;
	public  float GBP_USD_BID;
	
	public  float EUR_GBP_BID;
	
	public  float EUR_USD_ASK;
	public  float GBP_USD_ASK;
	public  float EUR_GBP_ASK;
	
	public String date;
	

	public  float getGBP_USD_BID() {
		return GBP_USD_BID;
	}

	public  void setGBP_USD_BID(float gBP_USD_BID) {
		GBP_USD_BID = gBP_USD_BID;
	}

	public Rates() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Rates(float eURO_IR_BID, float uSD_IR_BID, float gBP_IR_BID, float eURO_IR_ASK, float uSD_IR_ASK,
			float gBP_IR_ASK, float eUR_USD_BID, float gBP_USD_BID, float eUR_GBP_BID, float eUR_USD_ASK,
			float gBP_USD_ASK, float eUR_GBP_ASK, String date) {
		super();
		EURO_IR_BID = eURO_IR_BID;
		USD_IR_BID = uSD_IR_BID;
		GBP_IR_BID = gBP_IR_BID;
		EURO_IR_ASK = eURO_IR_ASK;
		USD_IR_ASK = uSD_IR_ASK;
		GBP_IR_ASK = gBP_IR_ASK;
		EUR_USD_BID = eUR_USD_BID;
		GBP_USD_BID = gBP_USD_BID;
		EUR_GBP_BID = eUR_GBP_BID;
		EUR_USD_ASK = eUR_USD_ASK;
		GBP_USD_ASK = gBP_USD_ASK;
		EUR_GBP_ASK = eUR_GBP_ASK;
		this.date = date;
	}

	public  float getGBP_USD_ASK() {
		return GBP_USD_ASK;
	}

	public  void setGBP_USD_ASK(float gBP_USD_ASK) {
		GBP_USD_ASK = gBP_USD_ASK;
	}


	public  float getEURO_IR_BID() {
		return EURO_IR_BID;
	}

	public  void setEURO_IR_BID(float eURO_IR_BID) {
		EURO_IR_BID = eURO_IR_BID;
	}

	public  float getGBP_IR_BID() {
		return GBP_IR_BID;
	}

	public  void setGBP_IR_BID(float gBP_IR_BID) {
		GBP_IR_BID = gBP_IR_BID;
	}

	public  float getEURO_IR_ASK() {
		return EURO_IR_ASK;
	}

	public  void setEURO_IR_ASK(float eURO_IR_ASK) {
		EURO_IR_ASK = eURO_IR_ASK;
	}

	public  float getGBP_IR_ASK() {
		return GBP_IR_ASK;
	}

	public  void setGBP_IR_ASK(float gBP_IR_ASK) {
		GBP_IR_ASK = gBP_IR_ASK;
	}

	public  float getEUR_USD_BID() {
		return EUR_USD_BID;
	}

	public  void setEUR_USD_BID(float eUR_USD_BID) {
		EUR_USD_BID = eUR_USD_BID;
	}

	public  float getEUR_GBP_BID() {
		return EUR_GBP_BID;
	}

	public  float getUSD_IR_BID() {
		return USD_IR_BID;
	}

	public  void setUSD_IR_BID(float uSD_IR_BID) {
		USD_IR_BID = uSD_IR_BID;
	}

	public  float getUSD_IR_ASK() {
		return USD_IR_ASK;
	}

	public  void setUSD_IR_ASK(float uSD_IR_ASK) {
		USD_IR_ASK = uSD_IR_ASK;
	}

	public  void setEUR_GBP_BID(float eUR_GBP_BID) {
		EUR_GBP_BID = eUR_GBP_BID;
	}

	public  float getEUR_USD_ASK() {
		return EUR_USD_ASK;
	}

	public  void setEUR_USD_ASK(float eUR_USD_ASK) {
		EUR_USD_ASK = eUR_USD_ASK;
	}

	public  float getEUR_GBP_ASK() {
		return EUR_GBP_ASK;
	}

	public  void setEUR_GBP_ASK(float eUR_GBP_ASK) {
		EUR_GBP_ASK = eUR_GBP_ASK;
	}

	
}