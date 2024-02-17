<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Your Title Here</title>
    <link rel="stylesheet" type="text/css" href="CustomerHomeStyle.css">
</head>
<body>
    <div class="container">
        <% 
            String msg = (String)request.getAttribute("msg");
            if(msg != null && !msg.isEmpty()) {
        %>
        <div class="message">
            <%= msg %>
        </div>
        <% } %>
        <jsp:include page="Customer.html"/>
    </div>
</body>
</html>
