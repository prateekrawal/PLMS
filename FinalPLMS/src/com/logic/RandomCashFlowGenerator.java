package com.logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import com.pojo.Account;
import com.pojo.Transaction;

public class RandomCashFlowGenerator {

	Random random = new Random();
	Account account = new Account();
	DecimalFormat df = new DecimalFormat("#.####");

	public void cashflow() {
		generateCashflow(account.getAccountNo_EURO());
		generateCashflow(account.getAccountNo_USD());
		generateCashflow(account.getAccountNo_GBP());
	}

	public ArrayList<Transaction> generateCashflow(long accno) {
		int cnt = (int) (((Math.random() * ((10 - 1)))) + 30);
		ArrayList<Transaction> t_AL = new ArrayList<Transaction>();

		for (int i = 0; i < cnt; i++) {

			t_AL.add(createTransactions());
		}
		// func call to dao with (t_AL,accno);
		return t_AL;
	}

	public Transaction createTransactions() {
		Transaction t = new Transaction();
		t.setTransactionId(++App.TID_Counter);
		int temp = (random.nextInt(10 - 1) + 1) % 2;
		if (temp == 0)
			t.setDebitCredit('C');
		else
			t.setDebitCredit('D');

		double data = random.nextDouble() * (7000000 - 1000000) + 7000000;
		t.setAmount(data);
		System.out.println(t.getDebitCredit());
		System.out.println("id" + t.getTransactionId());

		System.out.println("amount" + df.format(data));

		return t;
	}
}
