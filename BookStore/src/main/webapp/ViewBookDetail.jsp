<%@page import="java.util.Iterator"%>
<%@page import="com.pack.BookBean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.pack.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Book Details</title>
    <link rel="stylesheet" type="text/css" href="viewBooksStyle.css">
</head>
<body>
    <div class="container">
        <%
            AdminBean ab = (AdminBean) session.getAttribute("adminBean");
            ArrayList<BookBean> al = (ArrayList<BookBean>) session.getAttribute("list");
            out.println("<div class='admin-info'>Page belongs to admin : " + ab.getAdminUname() + "</div>");
            if (al.size() == 0) {
                out.println("No book details available");
            } else {
        %>
        <table>
            <tr>
                <th>Book Code</th>
                <th>Book name</th>
                <th>Author</th>
                <th>Prize</th>
                <th>Quantity</th>
                <th>Actions</th>
            </tr>
            <% 
                Iterator<BookBean> it = al.iterator();
                while (it.hasNext()) {
                    BookBean bb = it.next();
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrize() %></td>
                <td><%= bb.getQty() %></td>
                <td class="actions">
                    <a href='edit?bcode=<%= bb.getCode() %>'>Edit</a>
                    <a href='delete?bcode=<%= bb.getCode() %>'>Delete</a>
                </td>
            </tr>
            <% 
                }
            %>
        </table>
        <% 
            }
        %>
        <br>
        <div class="buttons">
            <a href="Book.html" class="button">Add Book</a>
            <a href="Logout.jsp" class="button">Logout</a> 
        </div>
    </div>
</body>
</html>
