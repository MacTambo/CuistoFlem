<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %><%--
  Created by IntelliJ IDEA.
  User: Arthur
  Date: 16/02/2022
  Time: 11:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CuistoFlem'</title>
    <link rel='stylesheet' type='text/css' href='vueHome.css'/>
</head>
<center>
    <body>
    <h1>BONJOUR FLEMMARD <br> Qu'as tu dans ton frigo?</h1>
    <form action="HomeServlet" method="post">

        <select name="ingredient1" id="ingredient1">
            <c:forEach var="drop" items="${dropdown}">
                <ul><li><option value=${drop}>${drop}</option></li></ul>
            </c:forEach>
        </select>
        <select name="ingredient2" id="ingredient2">
            <c:forEach var="drop" items="${dropdown}">
                <ul><li><option value=${drop}>${drop}</option></li></ul>
            </c:forEach>
        </select>
        <select name="ingredient3" id="ingredient3">
            <c:forEach var="drop" items="${dropdown}">
                <ul><li><option value=${drop}>${drop}</option></li></ul>
            </c:forEach>
        </select>
        <br><br><br><br><br><br>
        <input type="submit" value="Let's Flemme!">
    </form>
    </body>
</center>
</html>
