package com.logic;

public class RandomCashFlowGenerator {

	public void generateCashflow()
	{
		int cnt=(int) (((Math.random()*((10-1))))+30);
		System.out.println(cnt);
		for(int i=0;i<cnt;i++)
		{
			cashflow();
		}
	}
	
	
	public void cashflow()
	{
		
	}
}
