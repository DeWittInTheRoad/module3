<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>




<section id="centeredPanel">

    <c:url value="/parkDetails" var="formAction"/>



        <c:set var="parkCode" value="${param.parkCode}"/>
        <c:set var="tempSwitch" value="${param.tempSwitch}"/>
    <div>

        <c:set var = "parkImage" value = "${park.parkCode}.jpg"/>
        <c:set var = "lowerCaseCode" value = "${fn:toLowerCase(parkImage)}"/>

       <img src="img/parks/${lowerCaseCode}" style="max-height: 200px;"/><br>

        Park Name: <c:out value="${park.parkName}"/><br>
        State: <c:out value="${park.state}"/><br>
        Acreage: <c:out value="${park.acreage}"/><br>
        Elevation In Feet: <c:out value="${park.elevationInFeet}"/><br>
        Miles Of Trail: <c:out value="${park.milesOfTrail}"/><br>
        Climate: <c:out value="${park.climate}"/><br>
        Year Founded: <c:out value="${park.yearFounded}"/><br>
        Annual Visitor Count: <c:out value="${park.annualVisitorCount}"/><br>
        Number of Campsites:  <c:out value="${park.numberOfCampsites}"/><br>
        Inspirational Quote: <c:out value="${park.inspirationalQuote}"/><br>
        - <c:out value="${park.inspirationalQuoteSource}"/><br>
        Park Description: <c:out value="${park.parkDescription}"/><br>
        Entry Fee: <c:out value="${park.entryFee}"/><br>
        Number of Animal Species: <c:out value="${park.numberOfAnimalSpecies}"/><br>

    </div>

    <div>
        <%--<form method="POST" action="${formAction}">--%>
        <%--<!-- Rounded switch -->--%>
        <%--<label class="switch">--%>
        <%--<input type="checkbox" name="celsius" id ="celsius" value="celsius">--%>
        <%--<span class="slider round"></span>--%>
    <%--</label>--%>
            <%--<input type="submit" value="Submit"/>--%>
        <%--</form>--%>

            <%--<form method="GET" action="${formAction}">--%>
                <%--<select name="tempSwitch">--%>
                    <%--<option value="celsius">celsius</option>--%>
                    <%--<option value="fahrenheit">fahrenheit</option>--%>
                    <%--<input type="submit" value="Submit"/>--%>
                <%--</select>--%>
            <%--</form>--%>


        <c:forEach items="${weather}" var="weather">
            <img src="img/weather/${weather.forecast}.png" />
           Low: <c:out value="${weather.low}"/><br>
            High: <c:out value="${weather.high}"/><br>
        </c:forEach>
    </div>

</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />