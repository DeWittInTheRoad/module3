<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp"/>
<%--<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<<<<<<< HEAD
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
=======
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
>>>>>>> 558bc83b68e0cd317b5b04e3348c8ee3628eadf0


<section id="centeredPanel">
    <div id="parkDetailsContainer">

        <c:set var="parkCode" value="${param.parkCode}"/>
        <c:set var="tempSwitch" value="${param.tempSwitch}"/>
<<<<<<< HEAD
    <div>
        <c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg" />

        <c:set var ="lowerCaseImg" value = "${fn:toLowerCase(parkImage)}"/>

        <img src="${lowerCaseImg}" /><br>
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
        <c:url var="conversionSubmit" value="/parkDetails/${park.parkCode}" />
        <form method="post" action="${conversionSubmit}">
        <label>
            <input type="radio" name="convert" value="C">Celcius
            <input type="radio" name="convert" value="F" checked="checked">Fahrenheit
            <input type="submit">

        </label>
        </form>

    </div>

        <div id="today">
            <c:set var="today" value="${weather[0]}"/>
            <img src="/img/weather/${today.forecast}.png" />

            <c:choose>
                <c:when test="${convert == 'C'}">
                    <c:set var="highTemp" value="${(today.high - 32) / 1.8}" />
                    <c:set var="lowTemp" value="${(today.low - 32) / 1.8}" />
                    <c:set var="tempScale" value="°C" />
                </c:when>
                <c:otherwise>
                    <c:set var="highTemp" value="${today.high}" />
                    <c:set var="lowTemp" value="${today.low}" />
                    <c:set var="tempScale" value="°F" />

                </c:otherwise>
            </c:choose>

            <p>Low: <fmt:formatNumber maxFractionDigits="0" value="${lowTemp}" /><c:out value="${tempScale}"/></p>
            <p>High: <fmt:formatNumber maxFractionDigits="0" value="${highTemp}" /><c:out value="${tempScale}" /></p>
=======
        <c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>

        <c:set var="lowerCaseImg" value="${fn:toLowerCase(parkImage)}"/>
        <div id="imageAndQuote">
            <div id="mainImageContainer">
                <img id="parkDetailsMainImage" src="${lowerCaseImg}"/>
            </div>
            <div id="parkQuote">
                <p style="font-style: italic;">"<c:out value="${park.inspirationalQuote}"/>"</p>
                <p>- <c:out value="${park.inspirationalQuoteSource}"/><br>
            </div>
        </div>
>>>>>>> 558bc83b68e0cd317b5b04e3348c8ee3628eadf0

        <div id="parkName">
            <h1><c:out value="${park.parkName}"/></h1>
        </div>
        <div id="ParkStatsAndDescription">
            <div id="ParkStats">
                <p>State: <c:out value="${park.state}"/></p>
                <p>Acreage: <fmt:formatNumber type="number"
                                              maxFractionDigits="0" value="${park.acreage}"/></p>
                <p>Elevation In Feet: <fmt:formatNumber type="number"
                                                        maxFractionDigits="0" value="${park.elevationInFeet}"/></p>
                <p>Miles Of Trail: <fmt:formatNumber type="number"
                                                     maxFractionDigits="0" value="${park.milesOfTrail}"/></p>
                <p>Climate: <c:out value="${park.climate}"/></p>
                <p>Year Founded: <c:out value="${park.yearFounded}"/></p>
                <p>Annual Visitor Count: <fmt:formatNumber type="number"
                                                           maxFractionDigits="0"
                                                           value="${park.annualVisitorCount}"/></p>
                <p> Number of Campsites: <fmt:formatNumber type="number"
                                                           maxFractionDigits="0" value="${park.numberOfCampsites}"/></p>
                <p>Entry Fee: <fmt:setLocale value="en_US"/>
                    <fmt:formatNumber value="${park.entryFee}" type="currency"/></p>
                <p>Number of Animal Species: <fmt:formatNumber type="number"
                                                               maxFractionDigits="0"
                                                               value="${park.numberOfAnimalSpecies}"/></p>
            </div>
            <div id="ParkDescription">
                <p>Park Description: <c:out value="${park.parkDescription}"/></p>
            </div>
        </div>

        <div id="weather">
            <div id="today">
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
<<<<<<< HEAD
                <p>Low: <fmt:formatNumber maxFractionDigits="0" value="${lowTemp}" /><c:out value="${tempScale}"/></p>
                <p>High: <fmt:formatNumber maxFractionDigits="0" value="${highTemp}" /><c:out value="${tempScale}" /></p>
=======

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
>>>>>>> 558bc83b68e0cd317b5b04e3348c8ee3628eadf0
            </div>
            <c:forEach items="${weather}" var="weather" begin="1">
                <div id="fiveDayForecast">
                    <img src="/img/weather/${weather.forecast}.png"/>
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
                </div>
            </c:forEach>

        </div>
    </div>
</section>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>