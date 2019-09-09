package com.logic;

import java.util.Scanner;

import com.dao.UserDAOImpl;
import com.pojo.User;

public class SignUp {

	Scanner scan = new Scanner(System.in);
	User user = new User();

	public void start() {

		System.out.println("Enter userID : ");
		user.setUserId(scan.nextInt());
		System.out.println("Enter username : ");
		user.setUsername(scan.next());
		System.out.println("Enter password : ");
		user.setPassword(scan.next());
		System.out.println("Enter first name : ");
		user.setFirstName(scan.next());
		System.out.println("Enter last name : ");
		user.setLastName(scan.next());
		System.out.println("Enter mailId : ");
		user.setMailId(scan.next());
		System.out.println("Enter country : ");
		user.setCountry(scan.next());
		System.out.println("Enter phone number : ");
		user.setPhoneNo(scan.next());
		System.out.println("Enter account USD : ");
		user.setAccountNo_USD(scan.nextLong());
		System.out.println("Enter account EURO : ");
		user.setAccountNo_EURO(scan.nextLong());
		System.out.println("Enter account GBP : ");
		user.setAccountNo_GBP(scan.nextLong());

		UserDAOImpl userDaoImpl = new UserDAOImpl();
		userDaoImpl.addUser(user);
	}

}
