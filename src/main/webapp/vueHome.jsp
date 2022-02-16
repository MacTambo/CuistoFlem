<%--
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
        <option value="patate">patate</option>
    </select>
    <select name="ingredient2" id="ingredient2">
        <option value="oignon">oignon</option>
    </select>
    <select name="ingredient3" id="ingredient3">
        <option value="crème fraiche">crème fraiche</option>
    </select>
    <br><br><br><br><br><br>
    <input type="submit" value="Let's Flemme!">
</form>
</body>
</center>
</html>
