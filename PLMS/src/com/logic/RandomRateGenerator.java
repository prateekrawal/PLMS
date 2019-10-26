package com.logic;

import java.text.DecimalFormat;
import java.util.Random;

import com.dao.InterestDAO;
import com.dao.InterestDAOImpl;
import com.pojo.Rates;

public class RandomRateGenerator {

	Rates rate = new Rates();
	Random rand = new Random();
	DecimalFormat df = new DecimalFormat("#.####");
	DecimalFormat df1 = new DecimalFormat("#.##");
	InterestDAO interest_dao=new InterestDAOImpl();
	
	public void IR() {
		rate.USD_IR_BID = generateIR();
		rate.EURO_IR_BID = generateIR();
		rate.GBP_IR_BID = generateIR();

		rate.EURO_IR_ASK = (float) (rate.EURO_IR_BID * 0.005 + rate.EURO_IR_BID);
		rate.EURO_IR_ASK = Float.valueOf(df.format(rate.EURO_IR_ASK));

		rate.USD_IR_ASK = (float) (rate.USD_IR_BID * 0.005 + rate.USD_IR_BID);
		rate.USD_IR_ASK = Float.valueOf(df.format(rate.USD_IR_ASK));

		rate.GBP_IR_ASK = (float) (rate.GBP_IR_BID * 0.005 + rate.GBP_IR_BID);
		rate.GBP_IR_ASK = Float.valueOf(df.format(rate.GBP_IR_ASK));
		System.out.println("IR rates:");
		System.out.println("EURO Ask Rate:" + rate.EURO_IR_ASK);
		System.out.println("EURO Bid Rate:" + rate.EURO_IR_BID);
		System.out.println("USD Ask Rate:" + rate.USD_IR_ASK);
		System.out.println("USD Bid Rate:" + rate.USD_IR_BID);
		System.out.println("GBP Ask Rate:" + rate.GBP_IR_ASK);
		System.out.println("GBP Bid Rate:" + rate.GBP_IR_BID);
		interest_dao.addInterest(new Rates(rate.EURO_IR_BID, rate.USD_IR_BID, rate.GBP_IR_BID, rate.EURO_IR_ASK, rate.USD_IR_ASK, rate.GBP_IR_ASK,0f, 0f, 0f, 0f, 0f, 0f, "Date"));
	}

	public float generateIR() {

		float rate = 0;
		rate = (float) (((Math.random() * ((0.9999 + 0.9999)))) - 0.9999);
		rate = Float.valueOf(df.format(rate));
		return rate;
	}

	public void FX() {

		rate.EUR_USD_BID = generateFX(1.14, 1.2);
		rate.GBP_USD_BID = generateFX(1.24, 1.3);
		System.out.println("FX rates:");

		rate.EUR_USD_ASK = (float) (rate.EUR_USD_BID - 0.04);
		rate.GBP_USD_ASK = (float) (rate.GBP_USD_BID - 0.04);
		rate.EUR_USD_ASK = Float.valueOf(df1.format(rate.EUR_USD_ASK));
		rate.GBP_USD_ASK = Float.valueOf(df1.format(rate.GBP_USD_ASK));

		System.out.println("EUR_USD_BID Rate:" + rate.EUR_USD_BID);
		System.out.println("EUR_USD_ASK Rate:" + rate.EUR_USD_ASK);
		System.out.println("GBP_USD_BID Rate:" + rate.GBP_USD_BID);
		System.out.println("GBP_USD_ASK Rate:" + rate.GBP_USD_ASK);

		generate_EUR_GBP();
	}

	public void generate_EUR_GBP() {
		rate.EUR_GBP_BID = rate.EUR_USD_BID / rate.GBP_USD_BID;
		rate.EUR_GBP_ASK = rate.EUR_USD_ASK / rate.GBP_USD_ASK;
		// shows diff after three decimal places
		rate.EUR_GBP_BID = Float.valueOf(df1.format(rate.EUR_GBP_BID));
		rate.EUR_GBP_ASK = Float.valueOf(df1.format(rate.EUR_GBP_ASK));
		System.out.println("EUR_GBP_BID Rate:" + rate.EUR_GBP_BID);
		System.out.println("EUR_GBP_ASK Rate:" + rate.EUR_GBP_ASK);
	}

	public float generateFX(double min, double max) {

		float rate = 0;
		rate = (float) (((Math.random() * ((max - min)))) + min);
		rate = Float.valueOf(df1.format(rate));
		return rate;
	}

}