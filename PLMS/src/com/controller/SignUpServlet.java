package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;
import com.dao.AccountDAOImpl;
import com.dao.TransactionDAO;
import com.dao.TransactionDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.logic.RandomCashFlowGenerator;
import com.pojo.Account;
import com.pojo.User;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int userid=Integer.parseInt(request.getParameter("userid"));
		 String username=request.getParameter("username");
		 String password=request.getParameter("password");
		 String firstName=request.getParameter("FirstName");
		 String lastName=request.getParameter("LastName");
		 String mailId=request.getParameter("MailID");
		 String country=request.getParameter("Country");
		 String phoneNo=request.getParameter("PhoneNo");
		 long  accountNo_USD=Long.parseLong(request.getParameter("AccountUSD"));
		 long accountNo_EUR=Long.parseLong(request.getParameter("AccountEUR"));
		 long accountNo_GBP=Long.parseLong(request.getParameter("AccountGBP"));
		
		 UserDAO userDao=new UserDAOImpl();
		 AccountDAO accDAO=new AccountDAOImpl();
		 RandomCashFlowGenerator RCFG=new RandomCashFlowGenerator();
		
		 int rows=userDao.addUser(new User(userid, username, password, firstName, lastName, mailId, country, phoneNo, accountNo_USD, accountNo_EUR, accountNo_GBP));
		 int acc_details=accDAO.addAccountDetails(new Account(accountNo_USD, accountNo_EUR, accountNo_GBP) , new User(userid, username, password, firstName, lastName, mailId, country, phoneNo, accountNo_USD, accountNo_EUR, accountNo_GBP));
		 RCFG.cashflow(new Account(accountNo_USD, accountNo_EUR, accountNo_GBP));
		
		 if(rows>0) {
			 RequestDispatcher dispatcher= request.getRequestDispatcher("dashboard.jsp");
			 dispatcher.forward(request,response);
		 }
		 else {
			 RequestDispatcher dispatcher=request.getRequestDispatcher("signUp.jsp");
			 dispatcher.forward(request,response);
		 }
	}

}
