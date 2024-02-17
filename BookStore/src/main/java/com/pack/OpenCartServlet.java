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
@WebServlet("/openCart")
public class OpenCartServlet extends HttpServlet 
{
	@Override 
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws IOException,ServletException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else
		{
			CustomerBean cb = (CustomerBean) hs.getAttribute("custBean");
			ArrayList<BookBean> al  =  new OpenCartDAO().retriveCart(cb.getuName());
			if(al.size()==0)
			{
				req.setAttribute("msg", "Cart Is Empty");
				req.getRequestDispatcher("ViewAllProduct.jsp").forward(req, res);
			}
			else
			{
				hs.setAttribute("cartList", al);
				req.setAttribute("msg", "Your Cart");
				req.getRequestDispatcher("OpenCart.jsp").forward(req, res);
			
			}
		}
	}
}
