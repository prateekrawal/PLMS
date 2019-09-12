package com.pojo;

public class User {

	private int userId = 101;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mailId;
	private String country;
	private String phoneNo;

	private static long AccountNo_USD = 110111;
	private static long AccountNo_EURO = 110112;
	private static long AccountNo_GBP = 110113;

	public long getAccountNo_USD() {
		return AccountNo_USD;
	}

	public void setAccountNo_USD(long accountNo_USD) {
		AccountNo_USD = accountNo_USD;
	}

	public long getAccountNo_EURO() {
		return AccountNo_EURO;
	}

	public void setAccountNo_EURO(long accountNo_EURO) {
		AccountNo_EURO = accountNo_EURO;
	}

	public long getAccountNo_GBP() {
		return AccountNo_GBP;
	}

	public void setAccountNo_GBP(long accountNo_GBP) {
		AccountNo_GBP = accountNo_GBP;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

}
