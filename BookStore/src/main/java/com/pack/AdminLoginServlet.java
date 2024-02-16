package com.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/adminLogin")
public class AdminLoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res )throws IOException,ServletException
	{
		String uName = req.getParameter("uName");
		String pword = req.getParameter("pWord");
		AdminBean ab = new AdminLoginDAO().login(uName,pword);
		if(ab==null)
		{
			req.setAttribute("msg", "Invalid Login username or password not matching");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			HttpSession ht = req.getSession();
			ht.setAttribute("adminBean", ab);
			req.setAttribute("msg", "Login successfull..!!");
			RequestDispatcher rd = req.getRequestDispatcher("AdminLogin.jsp");
			rd.forward(req, res);
		}
		
	}
}
