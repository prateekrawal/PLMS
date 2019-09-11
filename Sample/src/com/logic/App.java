package com.logic;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import com.dao.AccountDAOImpl;
import com.dao.FXDAOImpl;
import com.dao.InterestDAOImpl;
import com.dao.JdbcConnection;
import com.pojo.Account;
import com.pojo.Transaction;
import com.pojo.User;

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
		RandomCashFlowGenerator RCG=new RandomCashFlowGenerator();
		RandomRateGenerator RRG = new RandomRateGenerator();
		Market market = new Market();
		User user=new User();
		Interest interest = new Interest();
		Account account = new Account();
		SignUp userDetails = new SignUp();
		Login login = new Login();
		FXDAOImpl fxDAO=new FXDAOImpl();
		InterestDAOImpl idao=new InterestDAOImpl();
//		AccountDAOImpl adao=new AccountDAOImpl();
		int ch = 0;
		System.out.println("\nOpening Balances: ");
		System.out.printf("\nEUR: %.4f", account.getOpeningBalance_EURO());
		System.out.printf("\nGBP: %.4f", account.getOpeningBalance_GBP());
		System.out.printf("\nUSD: %.4f", account.getOpeningBalance_USD());
//		adao.addAccountDetails(account, user)
		System.out.println(
				"\n\n1. Edit FX Rate\n2. Initiate Cashflow\n3. Display end of the day balance in accounts\n4. Net balance in base currency\n5. Calculate lend/borrow\n6. End Day\n7. Enter Cashflow\n8. Notification Cashflow");
		System.out.println("Enter your choice:");
		ch = scan.nextInt();

		do {
			//adao.addAccountDetails(account);
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
			idao.addInterest();
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
//					login.start();
					
					RRG.changeFXIR();		
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
				case 7:
					market.userCashflow();
					break;
				case 8:
					RCG.generateCashflow(user.getAccountNo_EURO(), App.date,1);
					RCG.generateCashflow(user.getAccountNo_GBP(), App.date,1);
					RCG.generateCashflow(user.getAccountNo_USD(), App.date,1);
				}

				System.out.println(
						"\n\n1. Login\n2. Initiate Cashflow\n3. Display end of the day balance in accounts\n4. Net balance in base currency\n5. Calculate lend/borrow\n6. End Day\n7. Enter Cashflow\n8. Notification Cashflow");
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
