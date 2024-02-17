package com.pack;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/takeOutBooks")
public class TakeOutBooksServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws IOException,ServletException
	{
		HttpSession hs = req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else
		{
			CustomerBean cb = (CustomerBean) hs.getAttribute("custBean");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("cartList");
			
		}
	}
}
