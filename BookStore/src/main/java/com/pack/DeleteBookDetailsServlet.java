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
@WebServlet("/delete")
public class DeleteBookDetailsServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException
	{
		HttpSession hs = req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session expired login again");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
//			System.out.println("Else block deleteBookServlet");
			String bCode = req.getParameter("bcode");
			
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext())
			{
				bb=it.next();
				if(bCode.equals(bb.getCode()))
				{
					break;
				}
			}
			
			int k = new DeleteBookDetailsDAO().delete(bb.getCode());
//			System.out.println("bookcode: "+bb.getCode());
//			System.out.println(k+" is k value ");
			al.remove(bb);
			if(k>0)
			{
				req.setAttribute("msg", "Book Details Deleted");
				req.getRequestDispatcher("DeleteBookDetails.jsp").forward(req, res);
				
			}
			
			
		}
	}
}
