package com.pack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/customerRegServlet")
public class CustomerRegServlet extends HttpServlet 
{
	@Override
	protected void doPost(HttpServletRequest req , HttpServletResponse res )throws IOException, ServletException
	{
		CustomerBean cb = new CustomerBean();
		cb.setuName(req.getParameter("uName"));
		cb.setpWord(req.getParameter("pWord"));
		cb.setfName(req.getParameter("fName"));
		cb.setlName(req.getParameter("lName"));
		cb.setMailId(req.getParameter("mailId"));
		cb.setAddress(req.getParameter("address"));
		cb.setPhNo(Long.parseLong(req.getParameter("phNo")));
		
		int k = new CustomerRegDAO().registerCustomer(cb);
		
		if(k>0)
		{
			req.setAttribute("msg", "Registered successfull");
			req.getRequestDispatcher("CustomerReg.jsp").forward(req, res);
			
		}
	}
}
