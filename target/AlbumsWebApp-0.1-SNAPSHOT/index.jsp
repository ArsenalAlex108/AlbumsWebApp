<%-- 
    Document   : index
    Created on : Oct 4, 2023, 1:56:57 PM
    Author     : Khoapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Albums</title>
        <link rel="stylesheet" href="styles/main.css" type="text/css"/>
    </head>
    <body>  
        <p>${empty cookie.userEmail ? "" : "User Email: "} ${cookie.userEmail.value}</p>
        <h1>List of albums </h1>
        
        <p>
            <a href="download?action=checkUser&amp;productCode=8601">86 (the band) - True Life Songs and Pictures</a><br>
            <a href="download?action=checkUser&amp;productCode=pf01">Paddlefoot - The First CD</a><br>
            <a href="download?action=checkUser&amp;productCode=pf02">Paddlefoot - The Second CD</a><br>
            <a href="download?action=checkUser&amp;productCode=jr01">Joe Rut - Genuine Wood Grained Finish</a>
        </p>
    </body>
</html>
