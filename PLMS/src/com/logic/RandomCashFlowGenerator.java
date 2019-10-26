package com.logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import com.dao.TransactionDAO;
import com.dao.TransactionDAOImpl;
import com.pojo.Account;
import com.pojo.Transaction;

public class RandomCashFlowGenerator {

	Random random = new Random();
	Account account = new Account();
	DecimalFormat df = new DecimalFormat("#.####");
	TransactionDAO txn_dao=new TransactionDAOImpl();

	
	public void cashflow(Account account) {
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
		//func call to dao with (t_AL,accno);
		System.out.println("Going to Txn_dao add transaction");
		//System.out.println("t_Al : " + t_AL);
		txn_dao.addTransaction(t_AL, accno);
		System.out.println(" came back to randomcashflow class after Adding txn");
		return t_AL;
	}

	public Transaction createTransactions() {
		Transaction t = new Transaction();
		t.setTransactionId(++App.TID_Counter);
		int temp = (random.nextInt(10 - 1) + 1) % 2;
		if (temp == 0)
			t.setDebitCredit("Credit");
		else
			t.setDebitCredit("Debit");

		double data = random.nextDouble() * (7000000 - 1000000) + 7000000;
		t.setAmount(data);
		//System.out.println(t.getDebitCredit());
		//System.out.println("id" + t.getTransactionId());

		//System.out.println("amount" + df.format(data));
		//System.out.println("t : " + t);
		return t;
	}
}