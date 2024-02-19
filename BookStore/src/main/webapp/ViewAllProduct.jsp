<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="com.pack.BookBean" %>
<%@ page import="com.pack.CustomerBean" %>
<%@ page import="java.awt.print.Book" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>view all books</title>
    <link rel="stylesheet" type="text/css" href="ViewProductJSPStyle.css">

</head>
<body>
	<div class="container">
         <h3>  Page belongs to : <%= ((CustomerBean)session.getAttribute("custBean")).getfName() %>
        </h3>
        <p>
            <%= (String)request.getAttribute("msg") %>
          </p>
            <br>
         
        <table>
            <tr>
                <th>Code</th>
                <th>Name</th>
                <th>Author</th>
                <th>Prize</th>
                <th>Quantity</th>
                <th>Action</th>
            </tr>
            <%
                ArrayList<BookBean> al = (ArrayList<BookBean>)session.getAttribute("listProduct");
                Iterator<BookBean> it = al.iterator();
                while(it.hasNext()) {
                    BookBean bb = it.next();
            %>
            <tr>
                <td><%= bb.getCode() %></td>
                <td><%= bb.getName() %></td>
                <td><%= bb.getAuthor() %></td>
                <td><%= bb.getPrize() %></td>
                <td><%= bb.getQty() %></td>
                <td><a href='addProductToCart?bCode=<%= bb.getCode() %>' class="button">Add To Cart</a></td>
            </tr>
            <%
                }
            %>
        </table>
        <a href="openCart" class="button">Open Cart</a><br><br>
        <a href="CustomerLogout.jsp" class="button">Logout</a>
    </div>
</body>
</html>