package com.pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/addProductToCart")
public class AddProductToCartServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
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
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("listProduct");
			String bookCode = req.getParameter("bCode");
			Iterator<BookBean> it = al.iterator();
			BookBean bb = null;
			while(it.hasNext())
			{
				bb=it.next();
				if(bb.getCode().equals(bookCode))
				{
					break;
				}
			}
			CustomerBean cb =(CustomerBean) hs.getAttribute("custBean");
			int k = new AddProductToCartDAO().addProductToCart(bb,cb.getuName());
			if(k>0)
			{
				req.setAttribute("msg", "Product Added to cart");
				req.getRequestDispatcher("AddProductToCart.jsp").forward(req, res);
			}
			
			
		}
	}
}
