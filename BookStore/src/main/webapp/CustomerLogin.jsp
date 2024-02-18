<%@page import="com.pack.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer View</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
		CustomerBean cb = (CustomerBean)session.getAttribute("custBean");
		out.println(msg+"<br>");
		out.println("Page belongs to : "+cb.getfName()+"<br>");
	%>
		 <br><br>
	<a href="viewProduct">View All Products</a><br><br>
	
	<a href="CustomerLogout.jsp">Logout</a>
</body>
</html>