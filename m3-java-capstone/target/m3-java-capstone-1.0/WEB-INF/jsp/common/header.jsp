
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

<html>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>National Park Geek</title>
    <c:url value="/css/site.css" var="cssHref" />
    <link rel="stylesheet" href="${cssHref}">
</head>

<body>
<header>
    <c:url value="/" var="homePageHref" />
    <c:url value="/img/logo.png" var="logoSrc" />
    <a href="${homePageHref}">
        <img src="${logoSrc}" alt="National Park Geek logo" />
    </a>
</header>
<nav>
    <ul>
        <li><a href="/allParks">Home</a></li>
        <li><a href="survey">Survey</a></li>
    </ul>
</nav>