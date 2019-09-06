package com.logic;

public class App {

	public static int counter=0;
	public static int TID_Counter=100;

	public static void main(String [] args)
	{
		
		//signup();
		//Login() 
		//Dashboard() if login success else Login()
		Dashboard dashboard=new Dashboard();
		dashboard.start();
	}
	
}
