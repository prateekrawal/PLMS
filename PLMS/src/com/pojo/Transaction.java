package com.pojo;

public class Transaction {

	private char debitCredit;
	private double amount;
	private int transactionId;
	private StringBuilder timestamp;

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

	public StringBuilder getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(StringBuilder timestamp) {
		this.timestamp = timestamp;
	}

}