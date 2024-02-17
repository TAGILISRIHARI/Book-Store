package com.pack;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/edit")
public class EditBookDetailsServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException , ServletException 
	{
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Login Again");
			RequestDispatcher rd = req.getRequestDispatcher("Home.jsp");
			rd.forward(req, res);
		}
		else
		{
			AdminBean ab = (AdminBean)hs.getAttribute("adminBean");
			BookBean bb = null;
			String bCode = req.getParameter("bcode");
//			System.out.println("BookCode Edit page : "+bCode);
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("list");
			Iterator<BookBean> it = al.iterator();
			while(it.hasNext())
			{
				bb=it.next();
				if(bCode.equals(bb.getCode()))
				{
					break;
				}
					
			}
			req.setAttribute("bookBean", bb);
			req.getRequestDispatcher("EditBookDetails.jsp").forward(req, res);
			
			
 		}
	}
}
