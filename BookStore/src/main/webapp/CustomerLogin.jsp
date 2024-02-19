<%@page import="com.pack.CustomerBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Customer View</title>
    <link rel="stylesheet" type="text/css" href="CustomerLoginJSPStyle.css">

</head>
<body>
	 <div class="container">
            <h3>Page belongs to: ${sessionScope.custBean.fName}</h3>
            <p>${msg}</p>
       
        <br><br>
        <a href="viewProduct">View All Products</a><br><br>
        <a href="CustomerLogout.jsp">Logout</a>
    </div>
</body>
</html>