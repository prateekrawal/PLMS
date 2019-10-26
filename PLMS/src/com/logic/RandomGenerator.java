package com.logic;

import java.text.DecimalFormat;
import java.util.Random;

import com.pojo.Rates;

public class RandomGenerator {

	Rates data=new Rates();
	Random rand=new Random();
	DecimalFormat df=new DecimalFormat("#.####");
	
	public void IR()
	{
		data.USD_IR_BID=generateIR();
		data.EURO_IR_BID=generateIR();
		data.GBP_IR_BID=generateIR();
		
		data.EURO_IR_ASK=(float) (data.EURO_IR_BID*0.005+data.EURO_IR_BID);
		data.EURO_IR_ASK=Float.valueOf(df.format(data.EURO_IR_ASK));
		
		data.USD_IR_ASK=(float) (data.USD_IR_BID*0.005+data.USD_IR_BID);
		data.USD_IR_ASK=Float.valueOf(df.format(data.USD_IR_ASK));
		
		data.GBP_IR_ASK=(float) (data.GBP_IR_BID*0.005+data.GBP_IR_BID);
		data.GBP_IR_ASK=Float.valueOf(df.format(data.GBP_IR_ASK));
		
	}

	
	public float generateIR() {
		
		float rate=0;
			rate=(float) (((Math.random()*((0.9999+0.9999))))-0.9999);
			rate=Float.valueOf(df.format(rate));
			return rate;
	}

	public void FX() {

		double EUR_USD_Rate=generateFX(1.1,1.2,0.01);
		System.out.println("EUR/USD Conversion rate : " +EUR_USD_Rate);
		double GBP_USD_Rate=generateFX(1.2,1.3,0.01);
		System.out.println("GBP/USD Conversion rate : " +GBP_USD_Rate);

	}
	
public double generateFX(double min,double max,double step) {
	double rate= (Math.random()*((max-min)+1));
	double step_rate=rate - rate%step + min;
	double conversion_rate=Math.round(step_rate*100.0)/100.0;
	return conversion_rate;
}

}