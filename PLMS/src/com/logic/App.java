package com.logic;

import java.util.Scanner;

import com.dao.JdbcConnection;
import com.pojo.Account;

public class App {

	public static int counter = 0;
	public static int month=1;
	public static int TID_Counter = 100;

	public static void main(String[] args) {

//		JdbcConnection jdbc=new JdbcConnection();
//		jdbc.opsenConnection();

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
		SignUp userDetails = new SignUp();
		Login login = new Login();
		int ch = 0;
		System.out.println("\nOpening Balances: ");
		System.out.printf("\nEUR: %.4f", account.getOpeningBalance_EURO());
		System.out.printf("\nGBP: %.4f", account.getOpeningBalance_GBP());
		System.out.printf("\nUSD: %.4f", account.getOpeningBalance_USD());
		System.out.println(
				"\n\n1. Login\n2. Initiate Cashflow\n3. Display end of the day balance in accounts\n4. Net balance in base currency\n5. Calculate lend/borrow\n6. End Day");
		System.out.println("Enter your choice:");
		ch = scan.nextInt();

		do {
			RRG.IR();
			RRG.FX();

			System.out.println("\nDay:" + (++counter));
			System.out.println("\nOpening Balances: ");
			System.out.printf("\nEUR: %.4f", account.getOpeningBalance_EURO());
			System.out.printf("\nGBP: %.4f", account.getOpeningBalance_GBP());
			System.out.printf("\nUSD: %.4f", account.getOpeningBalance_USD());
			do {
				switch (ch) {
				case 1:
//					JdbcConnection jdbc=new JdbcConnection();
//					jdbc.openConnection();
//					userDetails.start();
					login.start();
					break;
				case 2:
					market.start();

					break;
				case 3:
					market.display_EOLBal();
					break;
				case 4:
					market.display_EOLBal_In_Base();
					break;
				case 5:
					interest.start();
					break;
				}

				System.out.println(
						"\n\n1. Login\n2. Initiate Cashflow\n3. Display end of the day balance in accounts\n4. Net balance in base currency\n5. Calculate lend/borrow\n6. End Day");
					System.out.println("Enter your choice:");
				ch = scan.nextInt();
			} while (ch != 6);

			System.out.println("Start new Day?(y/n)");
			choice = scan.next().charAt(0);
		} while (choice == 'y');
		scan.close();
	}

}
