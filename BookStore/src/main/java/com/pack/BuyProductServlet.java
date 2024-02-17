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
@WebServlet("/buyProducts")
public class BuyProductServlet extends HttpServlet 
{
	
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req , HttpServletResponse res )throws IOException,ServletException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
		}
		else
		{
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("cartList");
			BookBean bb =  null;
			
			Iterator<BookBean> it = al.iterator();
			 long totalCost = 0;
			 long productCost = 0;
			while(it.hasNext())
			{
				bb=it.next();
				String bCode = bb.getCode();
				long reqQty = Long.parseLong(req.getParameter(bCode));
				productCost = bb.getPrize()*reqQty;
				res.getWriter().println(productCost);	
				totalCost= totalCost+productCost;
				res.getWriter().println(totalCost);	
				
			}
			int size = al.size();
			
			while(al.size()== size)
			{
				UpdateProductDetailsAfterBillServlet obj = new UpdateProductDetailsAfterBillServlet();
				obj.doGet(req, res);
				size--;
			}
			req.setAttribute("totalCost", totalCost);
			req.getRequestDispatcher("BuyProducts.jsp").forward(req, res);	
		}
	}
}

