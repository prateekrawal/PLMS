package com.logic;

import java.text.DecimalFormat;
import java.util.Random;

import com.pojo.Rates;

public class RandomRateGenerator {

	Rates rate=new Rates();
	Random rand=new Random();
	DecimalFormat df=new DecimalFormat("#.####");
	
	public void IR()
	{
		rate.USD_IR_BID=generateIR();
		rate.EURO_IR_BID=generateIR();
		rate.GBP_IR_BID=generateIR();
		
		rate.EURO_IR_ASK=(float) (rate.EURO_IR_BID*0.005+rate.EURO_IR_BID);
		rate.EURO_IR_ASK=Float.valueOf(df.format(rate.EURO_IR_ASK));
		
		rate.USD_IR_ASK=(float) (rate.USD_IR_BID*0.005+rate.USD_IR_BID);
		rate.USD_IR_ASK=Float.valueOf(df.format(rate.USD_IR_ASK));
		
		rate.GBP_IR_ASK=(float) (rate.GBP_IR_BID*0.005+rate.GBP_IR_BID);
		rate.GBP_IR_ASK=Float.valueOf(df.format(rate.GBP_IR_ASK));
		
	}

	
	public float generateIR() {
		
		float rate=0;
			rate=(float) (((Math.random()*((0.9999+0.9999))))-0.9999);
			rate=Float.valueOf(df.format(rate));
			return rate;
	}

	public void FX() {

		double EUR_USD_Rate=generateFX(1.1,1.2,0.01);
		double GBP_USD_Rate=generateFX(1.2,1.3,0.01);
		
	}
	
public double generateFX(double min,double max,double step) {
	double rate= (Math.random()*((max-min)+1));
	double step_rate=rate - rate%step + min;
	double conversion_rate=Math.round(step_rate*100.0)/100.0;
	return conversion_rate;
}

}
