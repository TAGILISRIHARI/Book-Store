<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.pack.AdminBean"%>
<%@ page import="com.pack.BookBean"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Edit Book Details</title>
     <link rel="stylesheet" type="text/css" href="EditBookDetailsStyle.css">
</head>
<body>
    <%
        AdminBean ab = (AdminBean)session.getAttribute("adminBean");
        BookBean bb = (BookBean)request.getAttribute("bookBean");
    %>
    <div class="container">
    	 <h2>Page belongs to admin: <%= ab.getAdminUname() %></h2>
        <h4>Edit book details </h4>
       
        <form action="updateDetails" method="POST">
            <input type="hidden" name="bCode" value="<%= bb.getCode() %>">
            <label>Book Prize :</label>
            <input type="text" name="bPrize" value="<%= bb.getPrize() %>">
            <br>
            <label>Book Quantity :</label>
            <input type="text" name="bQty" value="<%= bb.getQty() %>">
            <br>
            <input type="submit" value="Update Details">
        </form>
    </div>
</body>
</html>
