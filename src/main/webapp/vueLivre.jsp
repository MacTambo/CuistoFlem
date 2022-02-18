<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<body>
<center>
    <div id="warning"><h1>AVEC TON STOCK, TU PEUX TE FAIRE :</h1>
    </div>
</center>
<div id="title">
    <h1 style="color: black">${nom}</h1>
</div>
<div id="recipe">
    <img src=${img}>
    <div id="components">
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <circle cx="12" cy="12" r="10"></circle>
                <polyline points="12 6 12 12 16 14"></polyline>
            </svg>
            <h2 style="color: #a90000">Temps de préparation:</h2></div>
        <h2>${tempsPrepa} minutes.</h2>
        <br>
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M14 2H6a2 2 0 0 0-2 2v16c0 1.1.9 2 2 2h12a2 2 0 0 0 2-2V8l-6-6z"/>
                <path d="M14 3v5h5M16 13H8M16 17H8M10 9H8"/>
            </svg>
            <h2 style="color: #a90000">Ingredients:</h2>
        </div>
        <h2>${ingredients}.</h2>
        <br><br>
        <h2>${texte}</h2></div>
</div>
<c:if test="${not empty nom2}">
    <div id="title2">
        <h1 style="color: black">${nom2}</h1>
    </div>
<div id="recipe2">
    <img src=${img2}>
    <div id="components2">
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <circle cx="12" cy="12" r="10"></circle>
                <polyline points="12 6 12 12 16 14"></polyline>
            </svg>
            <h2 style="color: #a90000">Temps de préparation:</h2></div>
        <h2>${tempsPrepa2} minutes.</h2>
        <br>
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M14 2H6a2 2 0 0 0-2 2v16c0 1.1.9 2 2 2h12a2 2 0 0 0 2-2V8l-6-6z"/>
                <path d="M14 3v5h5M16 13H8M16 17H8M10 9H8"/>
            </svg>
            <h2 style="color: #a90000">Ingredients:</h2>
        </div>
        <h2>${ingredients2}.</h2>
        <br><br>
        <h2>${texte2}</h2></div>
</div>
</c:if>
<c:if test="${not empty nom3}">
    <div id="title3">
        <h1 style="color: black">${nom3}</h1>
    </div>
<div id="recipe3">
    <img src=${img3}>
    <div id="components3">
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <circle cx="12" cy="12" r="10"></circle>
                <polyline points="12 6 12 12 16 14"></polyline>
            </svg>
            <h2 style="color: #a90000">Temps de préparation:</h2></div>
        <h2>${tempsPrepa3} minutes.</h2>
        <br>
        <div class="littlelabel">
            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none"
                 stroke="#000000" stroke-width="2" stroke-linecap="round" stroke-linejoin="round">
                <path d="M14 2H6a2 2 0 0 0-2 2v16c0 1.1.9 2 2 2h12a2 2 0 0 0 2-2V8l-6-6z"/>
                <path d="M14 3v5h5M16 13H8M16 17H8M10 9H8"/>
            </svg>
            <h2 style="color: #a90000">Ingredients:</h2>
        </div>
        <h2>${ingredients3}.</h2>
        <br><br>
        <h2>${texte3}</h2></div>
</div>
</c:if>
</body>
</html>
