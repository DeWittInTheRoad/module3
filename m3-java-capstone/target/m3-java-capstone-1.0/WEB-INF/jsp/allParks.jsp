<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ page contentType="text/html;charset=UTF-8" language="java" %>




<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

<section id="centeredPanel">

    <c:forEach items="${allParks}" var="park">
        <c:url value="/parkDetails"
               var="parkDetailLink">
            <c:param name="parkCode value="${park.parkCode}"> </c:param>
    </c:url>

    <div style="display: flex;">
        <div>
            <a href="${parkDetailLink}"><img src="/img/${park.parkCode}.jpg" style="max-height: 200px;"/></a>

        </div>
        <div>
            <br>
            <c:out value="${park.}"/><br>
            <br>
            <p><fmt:formatNumber value = "${product.price}" type = "currency"/></p><br>
        </div>

        <br>
    </div>
    <hr style="border: 0; clear: both; display: block; width: 96%; background-color: #b5b5ad; height: 1px;">
    </c:forEach>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


