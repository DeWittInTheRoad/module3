<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>




<section id="centeredPanel">

    <c:forEach items="${allParks}" var="park">
        <div id="parkContainer">
        <c:url var="imgUrl" value="/img/parks/${park.parkCode}.jpg" />
        <c:url var="detailsUrl" value="/parkDetails/${park.parkCode}" />

    <div style="display: flex;">
        <div>
                    <c:set var = "parkImage" value = "${park.parkCode}.jpg"/>
                    <c:set var = "lowerCaseImg" value = "${fn:toLowerCase(parkImage)}"/>

            <a href="${detailsUrl}"><img src="img/parks/${lowerCaseImg}" style="max-height: 350px;border-radius: 25px 25px 25px 25px;"/></a>

        </div>
        <div>

            <a href="${detailsUrl}"><h3><c:out value="${park.parkName}"/></h3></a>
            <p><c:out value="${park.parkDescription}"/></p>

        </div>

        <br>
    </div>
        </div>
    <hr style="border: 0; clear: both; display: block; width: 96%; background-color: #b5b5ad; height: 1px;">
    </c:forEach>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


