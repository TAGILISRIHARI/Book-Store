<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register Success</title>
    <link rel="stylesheet" type="text/css" href="CustomerRegJSPStyle.css">
</head>
<body>
	<%
		String msg = (String)request.getAttribute("msg");
	%>
	<div class="container">
        <form action="customerLogin" method="post">
            <h1>Customer Login</h1>
            <label for="uName">Username</label>
            <input type="text" id="uName" name="uName" required autofocus>
            <label for="pWord">Password</label>
            <input type="password" id="pWord" name="pWord" required>
            <input type="submit" value="Login">
            <a href="CustomerReg.html">New Customer?</a>
            <h3 class="error-message"><%=msg%></h3>
        </form>
    </div>
</body>
</html>