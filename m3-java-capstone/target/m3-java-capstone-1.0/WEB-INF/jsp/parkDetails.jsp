<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<div class="grid-container">
    <c:set var="parkCode" value="${param.parkCode}"/>
    <c:set var="tempSwitch" value="${param.tempSwitch}"/>
    <c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>

    <c:set var="lowerCaseImg" value="${fn:toLowerCase(parkImage)}"/>
    <%--<img id="parkDetailsMainImage" src="${lowerCaseImg}"/>--%>

    <div class="gridParkInfo">
        <div class="gridParkName">
        <em class ="primary" style="font-size: 24px;"><c:out value="${park.parkName}"/></em>, <em class="ancillary" style="font-size: 20px; font-style: italic;"><c:out value="${park.state}"/></em>
    </div>
        <div class="gridParkDescription">
        <h5><c:out value="${park.parkDescription}"/></h5>
            </div>
        <div class="gridParkInfoColumn1">
        <p>Acreage: <fmt:formatNumber type="number"
                                      maxFractionDigits="0" value="${park.acreage}"/></p>
        <p>Elevation: <fmt:formatNumber type="number"
                                                maxFractionDigits="0" value="${park.elevationInFeet}"/> ft</p>
        <p>Trail Length: <fmt:formatNumber type="number"
                                             maxFractionDigits="0" value="${park.milesOfTrail}"/> mi</p>
        <p>Climate: <c:out value="${park.climate}"/></p>
        <p>Annual Visitor Count: <fmt:formatNumber type="number"
                                                   maxFractionDigits="0"
                                                   value="${park.annualVisitorCount}"/></p>
        </div>
        <div class="gridParkInfoColumn2">
        <p> Number of Campsites: <fmt:formatNumber type="number"
                                                   maxFractionDigits="0" value="${park.numberOfCampsites}"/></p>
        <p>Entry Fee: <fmt:setLocale value="en_US"/>
            <fmt:formatNumber value="${park.entryFee}" type="currency"/></p>
        <p>Animal Species: <fmt:formatNumber type="number"
                                                       maxFractionDigits="0"
                                                       value="${park.numberOfAnimalSpecies}"/></p>
        <p>Annual Visitor Count: <fmt:formatNumber type="number"
                                                   maxFractionDigits="0"
                                                   value="${park.annualVisitorCount}"/></p>
        <p>Est: <c:out value="${park.yearFounded}"/></p>
        </div>

    </div>

    <div class="gridParkImage" style="background: url('${lowerCaseImg}') no-repeat center center; background-size: 85%">
        <c:set var="parkCode" value="${param.parkCode}"/>
        <c:set var="tempSwitch" value="${param.tempSwitch}"/>
        <c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>

        <c:set var="lowerCaseImg" value="${fn:toLowerCase(parkImage)}"/>
        <%--<img id="parkDetailsMainImage" src="${lowerCaseImg}"/>--%>
        "<c:out value="${park.inspirationalQuote}"/>"
       - <c:out value="${park.inspirationalQuoteSource}"/>

    </div>

    <%--<div class="gridParkDescription">--%>
        <%--<p>Park Description: <c:out value="${park.parkDescription}"/></p>--%>
    <%--</div>--%>


    <div class="gridWeatherToday">
        <c:set var="today" value="${weather[0]}"/>
        <img src="/img/weather/${today.forecast}.png"/>

        <c:choose>
            <c:when test="${convert == 'C'}">
                <c:set var="highTemp" value="${(today.high - 32) / 1.8}"/>
                <c:set var="lowTemp" value="${(today.low - 32) / 1.8}"/>
                <c:set var="tempScale" value="°C"/>
            </c:when>
            <c:otherwise>
                <c:set var="highTemp" value="${today.high}"/>
                <c:set var="lowTemp" value="${today.low}"/>
                <c:set var="tempScale" value="°F"/>

            </c:otherwise>
        </c:choose>

        <p>Low: <fmt:formatNumber type="number"
                                  maxFractionDigits="0" value="${lowTemp}"/> <c:out value="${tempScale}"/>
            High: <fmt:formatNumber type="number"
                                    maxFractionDigits="0" value="${highTemp}"/> <c:out
                    value="${tempScale}"/></p>
        <c:url var="conversionSubmit" value="/parkDetails/${park.parkCode}"/>
        <form method="post" action="${conversionSubmit }">
            <label><input type="radio" name="convert" value="C"> C
                <input type="radio" name="convert" value="F"> F
                <input type="submit">

            </label>
        </form>


        <c:if test="${today.forecast == 'rain'}">
            <p>Pack rain gear and wear waterproof shoes</p>
        </c:if>
        <c:if test="${today.forecast == 'snow'}">
            <p>Pack snow shoes</p>
        </c:if>
        <c:if test="${today.forecast == 'sunny'}">
            <p>Pack sunblock</p>
        </c:if>
        <c:if test="${today.forecast == 'thunderstorms'}">
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
    <div class="gridWeather4Day">
        <c:forEach items="${weather}" var="weather" begin="1">
            <img src="/img/weather/${weather.forecast}.png" style="height: 10px;"/>

            <c:choose>
                <c:when test="${convert == 'C'}">
                    <c:set var="highTemp" value="${(weather.high - 32) / 1.8}"/>
                    <c:set var="lowTemp" value="${(weather.low - 32) / 1.8}"/>
                    <c:set var="tempScale" value="°C"/>
                </c:when>
                <c:otherwise>
                    <c:set var="highTemp" value="${weather.high}"/>
                    <c:set var="lowTemp" value="${weather.low}"/>
                    <c:set var="tempScale" value="°F"/>

                </c:otherwise>
            </c:choose>

            <p>Low: <fmt:formatNumber type="number"
                                      maxFractionDigits="0" value="${lowTemp}"/> <c:out
                    value="${tempScale}"/>
                High: <fmt:formatNumber type="number"
                                        maxFractionDigits="0" value="${highTemp}"/> <c:out
                        value="${tempScale}"/></p>
        </c:forEach>

    </div>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>