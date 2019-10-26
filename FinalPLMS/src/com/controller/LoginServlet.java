package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.UserDAO;
import com.dao.UserDAOImpl;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pwd = req.getParameter("pwd");
		
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		
		UserDAO userdao = new UserDAOImpl();
		try {
			if(userdao.validateUser(uname, pwd)) {
				RequestDispatcher d= req.getRequestDispatcher("welcome.html");		
				d.forward(req, resp);
			}
			else {
				out.print("<script>alert(\"Sorry username or password error\")</script>");  
		        RequestDispatcher rd=req.getRequestDispatcher("login.html");  
		        rd.include(req,resp);
			}
			out.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
