<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>


<section id="centeredPanel">

    <c:url var="pageUrl" value="/favoriteParks"/>
    <br>
    <ul>
        <c:forEach items="${allSurveys}" var="survey">
            <c:set var="parkImage" value="${survey.parkCode}.jpg"/>
            <c:set var="lowerCaseImg" value="${fn:toLowerCase(parkImage)}"/>

            <img src="img/parks/${lowerCaseImg}"/>
            Park Name: <c:out value="${survey.parkName}"/>
            Count: <c:out value="${survey.count}"/>


            <br>
            <hr>
        </c:forEach>
    </ul>
    <br>


</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp"/>
