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
@WebServlet("/updateDetails")
public class UpdateBookDetailsServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException,ServletException
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Login Again");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else 
		{
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			String bCode = req.getParameter("bCode");
			
			while(it.hasNext())
			{
				bb=it.next();
				if(bCode.equals(bb.getCode()))
				{
					break;
				}
			}
			
			bb.setPrize(Long.parseLong(req.getParameter("bPrize")));
			bb.setQty(Long.parseLong(req.getParameter("bQty")));
			int k = new UpdateBookDetailsDAO().update(bb);
			
			if(k>0)
			{
				req.setAttribute("msg", "Book details updated successfully..!!");
				req.getRequestDispatcher("UpdateBookDetails.jsp").forward(req, res);
			}
			
			
			
		}
	}
}
