package com.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.FXDAOImpl;
import com.dao.JdbcConnection;
import com.pojo.Account;
import com.pojo.Transaction;

public class App {

	public static int counter = 0;
	public static int month=1;
	public static int TID_Counter = 100;
	public static int MID_Counter = 100;
	public static String date;

	public static void main(String[] args) throws SQLException {


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
		FXDAOImpl fxDAO=new FXDAOImpl();
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

			System.out.println("\nDay:" + (++counter));
			StringBuilder sd = new StringBuilder();
			Transaction t = new Transaction();
			sd.append(String.valueOf(App.counter));
			sd.append("/");
			sd.append(App.month);
			sd.append("/19");
			System.out.println(sd);
			date = sd.toString();
			RRG.IR();
			RRG.FX();
			fxDAO.addFXRates();
			
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
		JdbcConnection jdbc=new JdbcConnection();
		Connection con=jdbc.openConnection();
		con.commit();
	}

}
