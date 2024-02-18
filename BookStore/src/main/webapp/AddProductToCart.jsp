<%@page import="com.pack.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add to cart</title>
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
	<jsp:include page="ViewAllProduct.jsp"/>
</body>
</html>