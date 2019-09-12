package com.logic;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import com.dao.TransactionDAO;
import com.dao.TransactionDAOImpl;
import com.pojo.Transaction;
import com.pojo.User;

public class RandomCashFlowGenerator {

	Random random = new Random();
	User user = new User();
	DecimalFormat df = new DecimalFormat("#.####");
	
	
//	public void cashflow() {
//		generateCashflow(user.getAccountNo_EURO());
//		generateCashflow(user.getAccountNo_USD());
//		generateCashflow(user.getAccountNo_GBP());
//	}

	public ArrayList<Transaction> generateCashflow(long accno,String date,int cnt) {
	
		
		TransactionDAOImpl tdao=new TransactionDAOImpl();
				ArrayList<Transaction> t_AL = new ArrayList<Transaction>();

		for (int i = 0; i < cnt; i++) {

			t_AL.add(createTransactions());
	
		}
		// func call to dao with (t_AL,accno);
		
		tdao.addTransaction(t_AL,date,String.valueOf(accno));
		Market m=new Market();
		char c;
		if(accno==1101)
			c='u';
		else if(accno==1102)
			c='e';
		else
			c='g';
		m.updateBal(t_AL, c);
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
	
	public void generateDate()
	{
		if(App.counter==30)
		{
			App.month++;
			App.counter=1;
		}
		
	}
}
