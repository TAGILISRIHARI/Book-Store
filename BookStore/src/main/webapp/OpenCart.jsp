<%@page import="java.util.Iterator"%>
<%@page import="com.pack.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<form action="takeOutBooks" method="get"> 
	<%
		String msg = (String)request.getAttribute("msg");
		out.println(msg+"<br>");
		CustomerBean cb = (CustomerBean) session.getAttribute("custBean");
		out.println("Page belongs to : "+cb.getfName()+"<br>");
		
		ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("cartList");
		Iterator<BookBean> it = al.iterator();
		BookBean bb = null;
		while(it.hasNext())
		{
			bb=it.next();
			out.println("Code:&nbsp&nbsp"+bb.getCode()+"<br>"+
						"Name:&nbsp&nbsp"+bb.getName()+"<br>"+
						"Author:&nbsp&nbsp"+bb.getAuthor()+"<br>"+
						"Prize:&nbsp&nbsp"+bb.getPrize()+"<br>"+
						"Avalible QTY:&nbsp&nbsp"+bb.getQty()+"<br>"+
						"Reruired QTY:&nbsp&nbsp <input type='number' name="+bb.getCode()+" min='1' max='"+bb.getQty()+"' value='1'"+"<br>"+
						"<br><a href='removeProductFromCart?bCode="+bb.getCode()+"'>Remove From Cart</a><br>");
		}
		if(al.size()>0)
		{
			out.println("<br><br><input type='submit' value ='Buy Products'>");
		}
	%>
	</form>
	<br><br>
	<a href="viewProduct">View All Products</a><br><br>
	
	<a href="CustomerLogout.jsp">Logout</a>
</body>
</html>