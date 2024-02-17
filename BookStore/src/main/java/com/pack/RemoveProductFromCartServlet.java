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
@WebServlet("/removeProductFromCart")
public class RemoveProductFromCartServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse res )throws IOException,ServletException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session expired");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else
		{
			String bCode = req.getParameter("bCode");
			ArrayList<BookBean> al = (ArrayList<BookBean>) hs.getAttribute("cartList");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext())
			{
				bb=it.next();
				if(bb.getCode().equals(bCode))
				{
					break;
				}
			}
			CustomerBean cb = (CustomerBean)hs.getAttribute("custBean");
			int k = new RemoveProductFromCartDAO().removeProductFromCart(bCode,cb.getuName());
			if(k>0)
			{
				req.setAttribute("msg", "Product removed from cart");
				al.remove(bb);
				hs.removeAttribute("cartList");
				hs.setAttribute("cartList", al);
				req.getRequestDispatcher("OpenCart.jsp").forward(req, res);
			}
			
		}
	}
}
