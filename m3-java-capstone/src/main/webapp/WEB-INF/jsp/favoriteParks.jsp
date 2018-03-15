<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:import url="/WEB-INF/jsp/common/header.jsp" />
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>


<section id="centeredPanel">

    <c:url var="pageUrl" value="/favoriteParks"/>
    <br>
    <span class="centered"> <a href="${pageUrl}">Post A Message</a></span>
    <ul>
        <c:forEach items="${allForumPosts}" var="survey">

            by <c:out value="${survey.parkCode}"/><br>

            <br>
            <hr>
        </c:forEach>
    </ul>
    <br>




</section>

<c:import url="/WEB-INF/jsp/common/footer.jsp" />
