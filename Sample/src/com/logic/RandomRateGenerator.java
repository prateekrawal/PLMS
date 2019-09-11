package com.logic;

import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;

import com.dao.FXDAOImpl;
import com.dao.InterestDAOImpl;
import com.pojo.Rates;
import com.pojo.Transaction;

public class RandomRateGenerator {

	Rates rate = new Rates();
	Random rand = new Random();
	DecimalFormat df = new DecimalFormat("#.####");
	DecimalFormat df1 = new DecimalFormat("#.##");

	InterestDAOImpl idao=new InterestDAOImpl();
			
	public void IR() {
		Rates.USD_IR_BID = generateIR();
		Rates.EURO_IR_BID = generateIR();
		Rates.GBP_IR_BID = generateIR();

		Rates.EURO_IR_ASK = (float) (Rates.EURO_IR_BID * 0.005 + Rates.EURO_IR_BID);
		Rates.EURO_IR_ASK = Float.valueOf(df.format(Rates.EURO_IR_ASK));

		Rates.USD_IR_ASK = (float) (Rates.USD_IR_BID * 0.005 + Rates.USD_IR_BID);
		Rates.USD_IR_ASK = Float.valueOf(df.format(Rates.USD_IR_ASK));

		Rates.GBP_IR_ASK = (float) (Rates.GBP_IR_BID * 0.005 + Rates.GBP_IR_BID);
		Rates.GBP_IR_ASK = Float.valueOf(df.format(Rates.GBP_IR_ASK));
		System.out.println("IR rates:");
		System.out.println("EURO Ask Rate:" + Rates.EURO_IR_ASK);
		System.out.println("EURO Bid Rate:" + Rates.EURO_IR_BID);
		System.out.println("USD Ask Rate:" + Rates.USD_IR_ASK);
		System.out.println("USD Bid Rate:" + Rates.USD_IR_BID);
		System.out.println("GBP Ask Rate:" + Rates.GBP_IR_ASK);
		System.out.println("GBP Bid Rate:" + Rates.GBP_IR_BID);

		
	rate.date=App.date;
	idao.addInterest();
	
	}

	public float generateIR() {

		float rate = 0;
		rate = (float) (((Math.random() * ((0.9999 + 0.9999)))) - 0.9999);
		rate = Float.valueOf(df.format(rate));
		return rate;
	}

	public void changeFXIR()
	{
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter IR :");
		System.out.println("euro bid:");
		Rates.EURO_IR_BID=sc.nextFloat();
		System.out.println("euro ask:");
		Rates.EURO_IR_ASK=sc.nextFloat();
		System.out.println("gbp bid:");
		Rates.GBP_IR_BID=sc.nextFloat();
		System.out.println("gbp ask:");
		Rates.GBP_IR_ASK=sc.nextFloat();
		System.out.println("usd bid:");
		Rates.USD_IR_BID=sc.nextFloat();
		System.out.println("usd ask:");
		Rates.USD_IR_ASK=sc.nextFloat();

		
		System.out.println("Enter FX:");
		System.out.println("Enter eur usd bid:");
		Rates.EUR_USD_BID=sc.nextFloat();
		System.out.println("Enter eur usd ask:");
		Rates.EUR_USD_ASK=sc.nextFloat();
//		System.out.println("Enter eur gbp bid:");
//		Rates.EUR_GBP_BID=sc.nextFloat();
//		System.out.println("Enter eur gbp ask:");
//		Rates.EUR_GBP_ASK=sc.nextFloat();
		System.out.println("Enter gbp usd bid:");
		Rates.GBP_USD_BID=sc.nextFloat();
		System.out.println("Enter gbp usd ask:");
		Rates.GBP_USD_ASK=sc.nextFloat();
		generate_EUR_GBP();
		
		FXDAOImpl fdao=new FXDAOImpl();
		fdao.addFXRates();
		idao.addInterest();
	}
	
	public void FX() {

		Rates.EUR_USD_BID = generateFX(1.14, 1.2);
		Rates.GBP_USD_BID = generateFX(1.24, 1.3);
		System.out.println("FX rates:");

		Rates.EUR_USD_ASK = (float) (Rates.EUR_USD_BID - 0.04);
		Rates.GBP_USD_ASK = (float) (Rates.GBP_USD_BID - 0.04);
		Rates.EUR_USD_ASK = Float.valueOf(df1.format(Rates.EUR_USD_ASK));
		Rates.GBP_USD_ASK = Float.valueOf(df1.format(Rates.GBP_USD_ASK));

		System.out.println("EUR_USD_BID Rate:" + Rates.EUR_USD_BID);
		System.out.println("EUR_USD_ASK Rate:" + Rates.EUR_USD_ASK);
		System.out.println("GBP_USD_BID Rate:" + Rates.GBP_USD_BID);
		System.out.println("GBP_USD_ASK Rate:" + Rates.GBP_USD_ASK);

		generate_EUR_GBP();
	}

	public void generate_EUR_GBP() {
		Rates.EUR_GBP_BID = Rates.EUR_USD_BID / Rates.GBP_USD_BID;
		Rates.EUR_GBP_ASK = Rates.EUR_USD_ASK / Rates.GBP_USD_ASK;
		// shows diff after three decimal places
		Rates.EUR_GBP_BID = Float.valueOf(df1.format(Rates.EUR_GBP_BID));
		Rates.EUR_GBP_ASK = Float.valueOf(df1.format(Rates.EUR_GBP_ASK));
		System.out.println("EUR_GBP_BID Rate:" + Rates.EUR_GBP_BID);
		System.out.println("EUR_GBP_ASK Rate:" + Rates.EUR_GBP_ASK);
	}

	public float generateFX(double min, double max) {

		float rate = 0;
		rate = (float) (((Math.random() * ((max - min)))) + min);
		rate = Float.valueOf(df1.format(rate));
		return rate;
	}

}
