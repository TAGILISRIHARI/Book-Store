package com.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/customerLogin")
public class CustomerLoginServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res)throws IOException, ServletException
	{
		String userName = req.getParameter("uName");
		String password = req.getParameter("pWord");
		CustomerBean cb  = new CustomerLoginDAO().loginCustomer(userName, password);
		
		if(cb==null)
		{
			req.setAttribute("msg", "Login failed try again");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else
		{
			HttpSession hs = req.getSession();
			hs.setAttribute("custBean", cb);
			req.setAttribute("msg", "Login was success");
			req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
		}
	}
}
