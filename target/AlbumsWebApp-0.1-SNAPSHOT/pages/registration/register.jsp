<%-- 
    Document   : register
    Created on : Oct 4, 2023, 2:07:57 PM
    Author     : Khoapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
        <link rel="stylesheet" href="../../../styles/main.css" type="text/css">
    </head>
    <body>
        <h1>Download registration</h1>
        <p>To register for our downloads, enter your name and email address below. Then, click on the Submit button.
        <form action="download" method="post">
            <input type="hidden" name="action" value="registerUser">
            <label class="pad_top" for="email">Email:</label>
            <input type="email" name="email" value="${user.info.email}" required><br>
            <label class="pad_top" for="firstName">First Name:</label>
            <input type="text" name="firstName" value="${user.info.firstName}" required><br>
            <label class="pad_top" for="lastName">Last Name:</label>
            <input type="text" name="lastName" value="${user.info.lastName}" required><br>
            <input type="submit" value="Register" class="margin_left">
        </form>
    </body>
</html>
