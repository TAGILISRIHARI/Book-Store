<%@page import="com.pack.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Admin Page</title>
    <link rel="stylesheet" type="text/css" href="AdminLoginJSP.css">
</head>
<body>
    <div class="container">
        <%
            AdminBean ab =(AdminBean) session.getAttribute("adminBean");
            String msg = (String)request.getAttribute("msg");
        %>
        <p class="header">Page belongs to admin : <%= ab.getAdminUname() %></p>
        <p class="message"><%= msg %></p>
        <div class="link-container">
            <a href="Book.html" class="button">Add Book</a><br><br>
            <a href="viewBookDetails" class="button">View All Books</a><br><br>
            <a href="Logout.jsp" class="button">Logout</a>
        </div>
    </div>
</body>
</html>
