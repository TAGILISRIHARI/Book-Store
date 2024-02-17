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
		CustomerBean cb = (CustomerBean) session.getAttribute("custBean");
		out.println("Page belongs to : "+cb.getfName());
		long totalCost  = (long)request.getAttribute("totalCost");
		out.println("Your Bill was :"+totalCost);
	%>
	
</body>
</html>