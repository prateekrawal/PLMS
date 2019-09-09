package com.logic;

import java.util.Scanner;

import com.pojo.Account;

public class App {

	public static int counter = 0;
	public static int TID_Counter = 100;

	public static void main(String[] args) {

//		//signup();
//		//Login() 
//		//Dashboard() if login success else Login()
//		Dashboard dashboard=new Dashboard();
//		dashboard.start();
		Scanner scan = new Scanner(System.in);
		char choice;
		RandomRateGenerator RRG = new RandomRateGenerator();
		Market market = new Market();
		Interest interest = new Interest();
		Account account = new Account();
		int ch = 0;
		System.out.println("\nOpening Balances: ");
		System.out.printf("\nEUR: %.4f", account.getOpeningBalance_EURO());
		System.out.printf("\nGBP: %.4f", account.getOpeningBalance_GBP());
		System.out.printf("\nUSD: %.4f", account.getOpeningBalance_USD());
		System.out.println(
				"\n1. Initiate Cashflow\n2. Display end of the day balance in accounts\n3. Net balance in base currency\n4. Calculate lend/borrow\n5. End Day");
		System.out.println("Enter your choice:");
		ch = scan.nextInt();

		do {
//			RRG.IR();
//			RRG.FX();

			System.out.println("Day:" + (++counter));
			System.out.println("\nOpening Balances: ");
			System.out.printf("\nEUR: %.4f", account.getOpeningBalance_EURO());
			System.out.printf("\nGBP: %.4f", account.getOpeningBalance_GBP());
			System.out.printf("\nUSD: %.4f", account.getOpeningBalance_USD());
			do {
				switch (ch) {
				case 1:
					market.start();

					break;
				case 2:
					market.display_EOLBal();
					break;
				case 3:
					market.display_EOLBal_In_Base();
					break;
				case 4:
					interest.start();
					break;
				}

				System.out.println(
						"\n1. Initiate Cashflow\n2. Display end of the day balance in accounts\n3. Net balance in base currency\n4. Calculate lend/borrow\n5. End Day");
				System.out.println("Enter your choice:");
				ch = scan.nextInt();
			} while (ch != 5);

			System.out.println("Start new Day?(y/n)");
			choice = scan.next().charAt(0);
		} while (choice == 'y');
		scan.close();
	}

}