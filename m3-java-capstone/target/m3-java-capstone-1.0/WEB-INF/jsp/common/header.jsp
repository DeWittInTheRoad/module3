<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>National Park Geek</title>
</head>
<body>

</body>
</html>

<html>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/site.css" var="cssHref"/>
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
<div class="navbar">
    <header>
        <c:url value="/" var="homePageHref"/>
        <c:url value="/img/logo.png" var="logoSrc"/>
        <a href="${homePageHref}">
            <img src="${logoSrc}" alt="National Park Geek logo"/>
        </a>
    </header>
    <nav>
        <p>
            <a href="/allParks">
                <span class="glyphicon glyphicon-home"></span>
            </a>
        </p>
        <p style="padding-left: 30px;">
            <a href="/survey">
                <span class="glyphicon glyphicon-list-alt">
        <p style="margin: 0px; padding-left: 10px; font-size: large; font-style: normal; padding-top: 5px;">
            Survey</p></span>
        </a>
        </p>
    </nav>
</div>