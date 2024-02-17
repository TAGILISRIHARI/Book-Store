<%@page import="com.pack.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Books-View</title>
    <link rel="stylesheet" type="text/css" href="UpdateBookDetailsStyle.css">
</head>
<body>
    <div class="container">
        <%
            String msg = (String)request.getAttribute("msg");
            AdminBean ab = (AdminBean)session.getAttribute("adminBean");
        %>
        <h2 class="admin-info">Page belongs to admin : <%= ab.getAdminUname() %></h2>
        <p class="message"><%= msg %></p>
        
        <br>
        <div class="actions">
            <a href="Book.html">Add Book</a>
            <a href="viewBookDetails">View All Books</a>
            <a href="Logout.jsp">Logout</a> 
        </div>
    </div>
</body>
</html>
