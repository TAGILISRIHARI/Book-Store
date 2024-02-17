package com.pack;

import java.awt.print.Book;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@SuppressWarnings("serial")
public class UpdateProductDetailsAfterBillServlet extends HttpServlet 
{
	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res )throws IOException,ServletException
	{
		HttpSession hs = req.getSession();
		if(hs==null)
		{
			req.setAttribute("msg", "Session Expired");
			req.getRequestDispatcher("CustomerHome.jsp").forward(req, res);
		}
		else
		{
			CustomerBean cb = (CustomerBean)hs.getAttribute("custBean");
			ArrayList<BookBean> al = (ArrayList<BookBean>)hs.getAttribute("cartList");
			BookBean bb = null;
			Iterator<BookBean> it = al.iterator();
			while (it.hasNext()) {
				bb =  it.next();
				UpdateProductDetailsAfterBillDAO objdao = new UpdateProductDetailsAfterBillDAO();
				objdao.updateProductAfterBill(Long.parseLong(req.getParameter(bb.getCode())), bb.getCode());
			}
		}
	}
}
