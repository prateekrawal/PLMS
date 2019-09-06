package com.pojo;
 
public class Transaction 
{

	
	private char debitCredit;
	private double amount;
	private int transactionId;
	private String timestamp;
	public char getDebitCredit() {
		return debitCredit;
	}
	public void setDebitCredit(char debitCredit) {
		this.debitCredit = debitCredit;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double d) {
		this.amount = d;
	}
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
	
}