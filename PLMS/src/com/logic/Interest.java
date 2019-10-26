package com.logic;

import com.pojo.Account;
import com.pojo.MoneyMarket;
import com.pojo.Rates;

public class Interest {
    
	Rates rate=new Rates();
	MoneyMarket mm = new MoneyMarket();
	char lb;
	char ctype;
	double IR_EURO;
	double IR_GBP;
	double IR_USD;

	public void start() {
		IR_EURO = calculateInterest(mm.getEURO_Base(), rate.getEURO_IR_BID(), rate.getEURO_IR_ASK());
//		System.out.println("interest gained in euro "+IR_EURO);
		double IR_EURO_USD = conversion(mm.getEURO_Base(), IR_EURO, rate.getEUR_USD_ASK(), rate.getEUR_USD_BID());
		IR_GBP = calculateInterest(mm.getGBP_Base(), rate.getGBP_IR_BID(), rate.getGBP_IR_ASK());
//		System.out.println("interest gained in gbp "+IR_GBP);
		double IR_GBP_USD = conversion(mm.getGBP_Base(), IR_GBP, rate.getGBP_USD_ASK(), rate.getGBP_USD_BID());
		IR_USD = calculateInterest(mm.getUSD_Base(), rate.getUSD_IR_BID(), rate.getUSD_IR_ASK());
//		System.out.println("interest gained in usd "+IR_USD);
		compare(IR_EURO_USD, IR_GBP_USD, IR_USD);

		nextDayOpenBal();
	}

	public void nextDayOpenBal() {
		Account account = new Account();
		if (lb == 'l') {
			if (ctype == 'u')
				account.setOpeningBalance_USD(account.getOpeningBalance_USD() + IR_USD);
			else if (ctype == 'g')
				account.setOpeningBalance_GBP(account.getOpeningBalance_GBP() + IR_GBP);
			else
				account.setOpeningBalance_EURO(account.getOpeningBalance_EURO() + IR_EURO);
		} else {
			if (ctype == 'u')
				account.setOpeningBalance_USD(account.getOpeningBalance_USD() - IR_USD);
			else if (ctype == 'g')
				account.setOpeningBalance_GBP(account.getOpeningBalance_GBP() - IR_GBP);
			else
				account.setOpeningBalance_EURO(account.getOpeningBalance_EURO() - IR_EURO);
		}
	}

	public double calculateInterest(double base, float bid, float ask) {

		double IR;
		if (base > 0) {
			IR = base * bid / 36500;
			
		} else {
			IR = base * ask / 36500;
		}
		return IR;
	}

	public double conversion(double base, double currAmt, float ask, float bid) {
		if (base > 0)
			currAmt = currAmt * ask;
		else
			currAmt = currAmt * bid;
		return currAmt;
	}

	public void compare(double IRe, double IRg, double IRu) {
		if (IRe < 0 && IRg < 0 && IRu < 0) {
			lb = 'b';
			if (IRe >= IRg) {
				if (IRe >= IRu) {
					System.out.printf("Borrow in EURO %.4f" , Math.abs(IRe));
					ctype = 'e';
				} else {
					System.out.printf("Borrow in USD %.4f" , Math.abs(IRu));
					ctype = 'u';
				}
			} else {
				if (IRg >= IRu) {
					System.out.printf("Borrow in GBP %.4f" , Math.abs(IRg));
					ctype = 'g';
				} else {
					System.out.printf("Borrow in USD %.4f" , Math.abs(IRu));
					ctype = 'u';
				}
			}
		} else {

			lb = 'l';
			if (IRe >= IRg) {
				if (IRe >= IRu) {
					System.out.printf("Invest in EURO %.4f" , IRe);
					ctype = 'e';
				} else {
					System.out.printf("Invest in USD %.4f" , IRu);
					ctype = 'u';
				}
			} else {
				if (IRg >= IRu) {
					System.out.printf("Invest in GBP %.4f" , IRg);
					ctype = 'g';
				} else {
					System.out.printf("Invest in USD %.4f" , IRu);
					ctype = 'u';
				}
			}
		}
	}
}