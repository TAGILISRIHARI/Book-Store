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
@WebServlet("/viewBookDetails")
public class ViewBooksServlet extends HttpServlet 
{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)throws IOException,ServletException
	{
		//Accessing Exiting Session
		HttpSession hs = req.getSession(false);
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired Login Agian");
			req.getRequestDispatcher("Home.jsp").forward(req, res);
			
		}
		else
		{
			
			ArrayList<BookBean> al = new ViewBookDetailsDAO().retrive();
			hs.setAttribute("list", al);
			req.getRequestDispatcher("ViewBookDetail.jsp").forward(req, res);
		}
	}
}
