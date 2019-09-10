package com.logic;

import java.util.Scanner;

import com.dao.LoginDAO;

public class Login {

	Scanner scan = new Scanner(System.in);
	// int uid = scan.nextInt();
	// call DAO function for fetching acc no by user id;
	// Pass that value to Random Cashflow gen
	// Fetch data and store in pojo ACc And user variable thorugh DAO

//	UserDetails userDetails=new UserDetails();
	LoginDAO loginDAO = new LoginDAO();

	public void start() {

		System.out.println("Enter the username:");
		String uname = scan.next();
		System.out.println("Enter the password");
		String pass = scan.next();
		uname = loginDAO.doLogin(uname, pass);
		if (uname.equals("no user"))
			System.out.println("Invalid credentials");
		else
			System.out.println(uname + " Logged in");
	}
}
