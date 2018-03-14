<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>




<section id="centeredPanel">

    <c:forEach items="${allParks}" var="park">
        <c:url value="/parkDetails"
               var="parkDetailLink">
            <c:param name="parkCode" value="${park.parkCode}"> </c:param>
    </c:url>

    <div style="display: flex;">
        <div>
                <%--img src="img/parks/"${fn:toLowerCase("${park.parkCode}").jpg""" --%>
                    <c:set var = "parkImage" value = "${park.parkCode}.jpg"/>
                    <c:set var = "lowerCaseCode" value = "${fn:toLowerCase(parkImage)}"/>

            <a href="${parkDetailLink}"><img src="img/parks/${lowerCaseCode}" style="max-height: 200px;"/></a>

        </div>
        <div>
            <br>

            <c:out value="${park.parkName}"/><br>
            <c:out value="${park.parkDescription}"/><br>
            <br>
        </div>

        <br>
    </div>
    <hr style="border: 0; clear: both; display: block; width: 96%; background-color: #b5b5ad; height: 1px;">
    </c:forEach>
</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />


