package com.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.AccountDAO;
import com.dao.AccountDAOImpl;
import com.dao.UserDAO;
import com.dao.UserDAOImpl;
import com.pojo.Account;
import com.pojo.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		String fname = req.getParameter("fname");
		String lname = req.getParameter("lname");
		String mail = req.getParameter("mail");
		String phno = req.getParameter("phone");
		
		double usdBalance = Double.parseDouble(req.getParameter("usdbal"));
		double eurBalance = Double.parseDouble(req.getParameter("eurbal"));
		double gbpBalance = Double.parseDouble(req.getParameter("gbpbal"));
		
		
		
		resp.setContentType("text/html");
		
		UserDAO userdao = new UserDAOImpl();
		User user = new User(uname, pwd, fname, lname, mail, phno);
		int user_rows=0;
		int user_id = 0;
		AccountDAO accountdao = new AccountDAOImpl();
		Account account = null;
		int account_rows=0;
		// list [account no] **ALWAYS**
		// 1 -> GBP
		// 2 -> USD
		// 3 -> EUR
		try {
			List<Long> accounts = accountdao.retriveAccountNumber();
			System.out.println(accounts);
			account = new Account(accounts.get(1),accounts.get(2),accounts.get(0),eurBalance,usdBalance,gbpBalance);
			user_id = userdao.retriveUserId();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		try {
			user_rows = userdao.addUser(user);
			account_rows = accountdao.addAccount(account,user_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(user_rows>0 && account_rows > 0) {
			RequestDispatcher d= req.getRequestDispatcher("login.html");		
			d.forward(req, resp);
		}
		else {
			RequestDispatcher d= req.getRequestDispatcher("signup.html");
			d.forward(req, resp);
		}
		
	}

}
