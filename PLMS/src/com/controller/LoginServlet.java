package com.controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.LoginDAO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		LoginDAO dao=new LoginDAO();
		String name=dao.doLogin(username, password);
		System.out.println("username : " +name);
		
		if(name.equals("no user")) {
			request.setAttribute("msg", "Sorry Credentials not mathcing");
			RequestDispatcher dispatcher=request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
		else { 
			HttpSession httpSession=request.getSession();
			System.out.println(httpSession.getId() + ":" + httpSession.getCreationTime());
			httpSession.setAttribute(username, name);
			RequestDispatcher dispatcher=request.getRequestDispatcher("welcome.jsp");  // Records fetched will be displayed here
			dispatcher.forward(request, response);
		}
	}

}
