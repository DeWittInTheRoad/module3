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

    <div class="gridParkInfo" style="padding-top: 0px; padding-bottom: 0px">
        <div class="gridParkName" style="background-color: darkgrey">
            <em class="primary" style="font-size: 24px;"><c:out value="${park.parkName}"/></em>, <em class="ancillary"
                                                                                                     style="font-size: 20px; font-style: italic;"><c:out
                value="${park.state}"/></em>
        </div>
        <div class="gridParkDescription" style="background-color: ghostwhite;">
            <h5><c:out value="${park.parkDescription}"/></h5>
        </div>

        <div class="gridParkInfoColumn1">
            <p><b>Acreage:</b> <fmt:formatNumber type="number"
                                                 maxFractionDigits="0" value="${park.acreage}"/></p>
            <p><b>Elevation:</b> <fmt:formatNumber type="number"
                                                   maxFractionDigits="0" value="${park.elevationInFeet}"/> ft</p>
            <p><b>Trail Length:</b> <fmt:formatNumber type="number"
                                                      maxFractionDigits="0" value="${park.milesOfTrail}"/> mi</p>
            <p><b>Climate:</b> <c:out value="${park.climate}"/></p>
        </div>


        <div class="gridParkInfoColumn2">
            <p><b> Number of Campsites:</b> <fmt:formatNumber type="number"
                                                              maxFractionDigits="0" value="${park.numberOfCampsites}"/>
            </p>
            <p><b>Entry Fee:</b> <fmt:setLocale value="en_US"/>
                <fmt:formatNumber value="${park.entryFee}" type="currency"/></p>
            <p><b>Animal Species:</b> <fmt:formatNumber type="number"
                                                        maxFractionDigits="0"
                                                        value="${park.numberOfAnimalSpecies}"/></p>
            <p><b>Annual Visitor Count:</b> <fmt:formatNumber type="number"
                                                              maxFractionDigits="0"
                                                              value="${park.annualVisitorCount}"/></p>
            <p><b>Est:</b> <c:out value="${park.yearFounded}"/></p>
        </div>

    </div>

    <div class="gridParkImage" style="background: url('${lowerCaseImg}') no-repeat center center; background-size: 85%">
        <c:set var="parkCode" value="${param.parkCode}"/>
        <c:set var="tempSwitch" value="${param.tempSwitch}"/>
        <c:url var="parkImage" value="/img/parks/${park.parkCode}.jpg"/>

        <c:set var="lowerCaseImg" value="${fn:toLowerCase(parkImage)}"/>
        <%--<img id="parkDetailsMainImage" src="${lowerCaseImg}"/>--%>
        <div class="parkQuote">"<c:out value="${park.inspirationalQuote}"/>"</div>
        <div class="parkQuoteSource">- <c:out value="${park.inspirationalQuoteSource}"/></div>

    </div>

    <%--<div class="gridParkDescription">--%>
    <%--<p>Park Description: <c:out value="${park.parkDescription}"/></p>--%>
    <%--</div>--%>


    <div class="gridWeatherToday">
        <c:set var="today" value="${weather[0]}"/>
        <div class="todayWeatherImage"
             style="background: url('/img/weather/${today.forecast}.png') no-repeat; background-size: contain">
            <%--<c:set var="today" value="${weather[0]}"/>--%>
            <%--<img src="/img/weather/${today.forecast}.png"/>--%>
        </div>

        <div class="todayTemperature">
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

            <h3>Low: <fmt:formatNumber type="number"
                                       maxFractionDigits="0" value="${lowTemp}"/> <c:out value="${tempScale}"/></h3>
            <h3>High: <fmt:formatNumber type="number"
                                        maxFractionDigits="0" value="${highTemp}"/> <c:out
                    value="${tempScale}"/></h3>
        </div>
        <div class="todayConversion">
            <c:url var="conversionSubmit" value="/parkDetails/${park.parkCode}"/>
            <form method="post" action="${conversionSubmit}">
            <c:if test="${convert == 'C'}">
                <c:set var="tempScaleSwitch" value="F"/>
                <label><input type="radio" name="convert" value="F" checked="checked"></label>

            </c:if>
            <c:if test="${convert == 'F'}">
                <c:set var="tempScaleSwitch" value="C"/>
                <input type="radio" name="convert" value="C" checked="checked">
            </c:if>
                <label> <input type="submit" value="Switch to ${tempScaleSwitch}"></label>

                <%--<label><input type="radio" name="convert" value="C"> C--%>
                    <%--<input type="radio" name="convert" value="F"> F--%>
                    <%--<input type="submit" value="Switch to ${tempScaleSwitch}">--%>

                <%--</label>--%>
            </form>

        </div>
        <div class="climateAdvisory">
            <c:if test="${today.forecast == 'rain'}">
                <p>Pack rain gear and wear waterproof shoes</p>
            </c:if>
            <c:if test="${today.forecast == 'snow'}">
                <p>Pack snow shoes</p>
            </c:if>
            <c:if test="${today.forecast == 'sunny'}">
                <p>Remember to wear sunblock</p>
            </c:if>
            <c:if test="${today.forecast == 'thunderstorms'}">
                <p>Seek shelter and avoid hiking on exposed ridges</p>
            </c:if>
        </div>
        <div class=temperatureAdvisory">
            <c:if test="${today.high > 75}">
                <p>Bring an extra gallon of water</p>
            </c:if>
            <c:if test="${today.low < 20}">
                <p>Danger of exposure to frigid temperatures</p>
            </c:if>
            <c:if test="${today.high - today.low > 20}">
                <p>Wear breathable layers</p>
            </c:if>
        </div>
    </div>

    <div class="gridWeather4Day">
        <c:forEach items="${weather}" var="weather" begin="1">
            <div class="fourDayCell">
                <div><img src="/img/weather/${weather.forecast}.png"/></div>

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

                <div><p>Low: <fmt:formatNumber type="number"
                                               maxFractionDigits="0" value="${lowTemp}"/> <c:out
                        value="${tempScale}"/>
                    High: <fmt:formatNumber type="number"
                                            maxFractionDigits="0" value="${highTemp}"/> <c:out
                            value="${tempScale}"/></p>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
<c:import url="/WEB-INF/jsp/common/footer.jsp"/>