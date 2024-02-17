package com.pack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
@WebServlet("/addBookDetails")
public class AddBookServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
	throws IOException,ServletException
	{
		//Accessing Existing session
		HttpSession hs = req.getSession(false);
		
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Login Again");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
		}
		else
		{
			BookBean bb = new BookBean();
			bb.setCode(req.getParameter("bookCode"));
			bb.setName(req.getParameter("bookName"));
			bb.setAuthor(req.getParameter("bookAuthor"));
			bb.setPrize(Long.parseLong(req.getParameter("bookPrize")));
			bb.setQty(Long.parseLong(req.getParameter("bookQTY")));
			
			int k = new AddBookDAO().addBook(bb);
			if(k>0)
			{
				req.setAttribute("msg", "Book details added..!!");
			}
		}
		RequestDispatcher rd = req.getRequestDispatcher("AddBookDetails.jsp");
		rd.forward(req, res);
	}
}
