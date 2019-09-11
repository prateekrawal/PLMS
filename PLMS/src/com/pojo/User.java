package com.pojo;

public class User {

	private int userId;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String mailId;
	private String country;
	private String phoneNo;
	private long  accountNo_USD;
	private long accountNo_EUR;
	private long accountNo_GBP;
	
	
	public User(int userId, String username, String password, String firstName, String lastName, String mailId,
			String country, String phoneNo, long accountNo_USD, long accountNo_EUR, long accountNo_GBP) {
		super();
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.mailId = mailId;
		this.country = country;
		this.phoneNo = phoneNo;
		this.accountNo_USD = accountNo_USD;
		this.accountNo_EUR = accountNo_EUR;
		this.accountNo_GBP = accountNo_GBP;
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
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


	public long getAccountNo_USD() {
		return accountNo_USD;
	}


	public void setAccountNo_USD(int accountNo_USD) {
		this.accountNo_USD = accountNo_USD;
	}


	public long getAccountNo_EUR() {
		return accountNo_EUR;
	}


	public void setAccountNo_EUR(int accountNo_EUR) {
		this.accountNo_EUR = accountNo_EUR;
	}


	public long getAccountNo_GBP() {
		return accountNo_GBP;
	}


	public void setAccountNo_GBP(int accountNo_GBP) {
		this.accountNo_GBP = accountNo_GBP;
	}
	
	
	
}
