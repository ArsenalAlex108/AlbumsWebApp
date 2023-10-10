<%-- 
    Document   : download
    Created on : Oct 4, 2023, 2:22:19 PM
    Author     : Khoapa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="../styles/main.css" type="text/css">
    </head>
    <body>
        <h1>Download</h1>
        <h2>${albumInfo.albumTitle}</h2>
        <c:if test="${not empty albumInfo.songs}">
            <table>
                <tr>
                    <th>Song Titles</th>
                    <th>Audio Format</th>
                </tr>
                <c:forEach items="${albumInfo.songs}" var="song">
                    <tr>
                        <td>${song.name}</td>
                        <td>
                            <a href=${song.source}>${song.format}</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>               
        </c:if>
    </body>
</html>
