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
@WebServlet("/viewProduct")
public class ViewAllProductsServlet extends HttpServlet 
{
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
			ArrayList<BookBean> al = new ViewAllProductsDAO().retriveProducts();
			
			if(al.size()==0)
			{
				req.setAttribute("msg","No products Avaliable");
				req.getRequestDispatcher("CustomerLogin.jsp").forward(req, res);
			}
			else
			{
				hs.setAttribute("listProduct", al);
				req.setAttribute("msg", "All Product Details");
				req.getRequestDispatcher("ViewAllProduct.jsp").forward(req, res);
				
			}
		}
	}
}
