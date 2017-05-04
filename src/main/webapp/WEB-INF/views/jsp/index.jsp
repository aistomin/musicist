<%@ page language="java" pageEncoding="UTF-8" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tag" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><spring:message code="project.title"/></title>
    <spring:url value="/resources/core/css/musicist.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
    <link href="${pageContext.request.contextPath}/resources/core/img/favicon.ico" rel="icon" type="image/x-icon" />
    <%@include file="login.jsp" %>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <a class="navbar-brand" href="${pageContext.request.contextPath}/"><spring:message code="project.title"/></a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown right-menu-selector">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">
                        <img class="right-menu-icon" src="/resources/core/img/flags/${pageContext.response.locale}.png"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="?locale=de" data-toggle="language" data-target="#de">
                            <img class="right-menu-icon"
                                 src="${pageContext.request.contextPath}/resources/core/img/flags/de.png"/>
                        </a></li>
                        <li><a href="?locale=en" data-toggle="language" data-target="#en">
                            <img class="right-menu-icon"
                                 src="${pageContext.request.contextPath}/resources/core/img/flags/en.png"/>
                        </a></li>
                        <li><a href="?locale=ru" data-toggle="language" data-target="#en">
                            <img class="right-menu-icon"
                                 src="${pageContext.request.contextPath}/resources/core/img/flags/ru.png"/>
                        </a></li>
                    </ul>
                </li>

                <tag:notloggedin>
                    <li><a href="#" data-toggle="modal" data-target="#login_dialog">
                        <spring:message code="menu.login"/></a></li>
                </tag:notloggedin>
                <tag:loggedin>
                    <li class="dropdown right-menu-selector">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            <img class="right-menu-icon" src="${facebook.getPictureURL(24, 24)}"/>
                            <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#"><spring:message code="menu.my.profile"/></a></li>
                            <li><a href="${pageContext.request.contextPath}/facebook/logout"><spring:message
                                    code="menu.logout"/></a></li>
                        </ul>
                    </li>
                </tag:loggedin>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
        <p>
            <tag:loggedin>
                <spring:message code="text.hello"/> ${facebook.name}!
            </tag:loggedin>
            <tag:notloggedin>
                <spring:message code="text.welcome"/> <spring:message code="project.title"/>!
            </tag:notloggedin>
        </p>
        <tag:loggedin>
            <p>Your email: ${facebook.getMe().getEmail()}</p>
        </tag:loggedin>
        <p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
        </p>
    </div>
</div>

<div class="container">

    <div class="row">
        <div class="col-md-4">
            <h2><spring:message code="notes"/></h2>
            <p>
                <c:forEach items="${notes}" var="note">
                    <spring:message code="${note.getI18nKey()}"/><br>
                </c:forEach>
            </p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>
            <p>ABC</p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details</a>
            </p>
        </div>
        <div class="col-md-4">
            <h2>Heading</h2>
            <p>ABC</p>
            <p>
                <a class="btn btn-default" href="#" role="button">View details</a>
            </p>
        </div>
    </div>


    <hr>
    <footer>
        <p>&copy; 2017 Andrej Istomin. <spring:message code="credit.text"/> <a rel="nofollow"
                                                                               href="https://www.vecteezy.com">vecteezy.com</a>,
            <a rel="nofollow" href="https://dribbble.com/msenyil">Muharrem Şenyıl</a></p>
    </footer>
</div>

<spring:url value="/resources/core/js/musicist.js" var="coreJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>