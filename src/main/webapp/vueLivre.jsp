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
    <title>Recettes</title>
    <link rel='stylesheet' type='text/css' href='vueLivre.css'/>
</head>
<center>
    <body>
    <h1>AVEC TON STOCK, TU PEUX TE FAIRE :</h1>
    <div id="warning">
        <h1>(Voilà ta recette avec : ${ingredient1} ${ingredient2} ${ingredient3})</h1>
    </div>
    <div id="title">
        <h1 style="color: black">${nom}</h1>
    </div>
    <div id="recipe">
        <img src=${img}>
        <div id="components">
            <h2 style="color: #a90000">Temps de préparation: </h2>
            <h2>${tempsPrepa} minutes.</h2>
            <br>
            <h2 style="color: #a90000">Ingredients: </h2>
            <h2>${ingredients}.</h2>
            <br><br>
            <h2>${texte}</h2></div>
    </div>
    </body>
</center>
</html>
