<%@page import="java.util.Iterator"%>
<%@page import="com.pack.BookBean"%>
<%@page import="java.awt.print.Book"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		out.println(msg+"<br>");
		CustomerBean cb = (CustomerBean) session.getAttribute("custBean");
		out.println("Page belongs to : "+cb.getfName()+"<br>");
		ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("listProduct");
		Iterator<BookBean> it = al.iterator();
		BookBean bb = null;
		while(it.hasNext())
		{
			bb=(BookBean)it.next();
			out.println(bb.getCode()+"&nbsp&nbsp"+bb.getName()+"&nbsp&nbsp"+bb.getAuthor()+"&nbsp&nbsp"+bb.getPrize()+"&nbsp&nbsp"+bb.getQty()+
					"<a href='addProductToCart?bCode="+bb.getCode()+"'>Add To Cart</a>");
					
			out.println("<br>");
		}
	%>
	<br><br>
	<a href="openCart">Open Cart</a><br><br>
	<a href="CustomerLogout.jsp">Logout</a>
</body>
</html>