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

    <div id="weather">
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

        <div id="today">
            <c:set var="today" value="${weather[0]}"/>
            <img src="img/weather/${today.forecast}.png" />
            <p>Low: <c:out value="${today.low}"/></p>
            <p>High: <c:out value="${today.high}"/></p>

            <c:if test ="${today.forecast == 'rain'}">
                <p>Pack rain gear and wear waterproof shoes</p>
            </c:if>
            <c:if test ="${today.forecast == 'snow'}">
                <p>Pack snow shoes</p>
            </c:if>
            <c:if test ="${today.forecast == 'sunny'}">
                <p>Pack sunblock</p>
            </c:if>
            <c:if test ="${today.forecast == 'thunderstorms'}">
                <p>Seek shelter and avoid hiking on exposed ridges</p>
            </c:if>
            <c:if test="${today.high > 75}">
                <p>Bring an extra gallon of water</p>
            </c:if>
            <c:if test="${today.high < 20}">
                <p>Danger of exposure to frigid temperatures</p>
            </c:if>
            <c:if test="${today.high - today.low > 20}">
                <p>Wear breathable layers</p>
            </c:if>
        </div>

        <c:forEach items="${weather}" var="weather" begin="1">
            <div id="fiveDayForecast">
            <img src="img/weather/${weather.forecast}.png" />
            <p>Low: <c:out value="${weather.low}"/></p>
            <p>High: <c:out value="${weather.high}"/></p>
            </div>
        </c:forEach>
        </div>

</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp" />