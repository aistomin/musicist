<%@ page language="java" pageEncoding="UTF-8"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title><spring:message code="project.title"/></title>
    <spring:url value="/resources/core/css/musicist.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
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
                <li class="dropdown pay-language-selector">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                        <img class="lang-flag" src="/resources/core/img/flags/${pageContext.response.locale}.png"/>
                        <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="?locale=de" data-toggle="language" data-target="#de">
                            <img class="lang-flag" src="${pageContext.request.contextPath}/resources/core/img/flags/de.png"/>
                        </a></li>
                        <li><a href="?locale=en" data-toggle="language" data-target="#en">
                            <img class="lang-flag" src="${pageContext.request.contextPath}/resources/core/img/flags/en.png"/>
                        </a></li>
                        <li><a href="?locale=ru" data-toggle="language" data-target="#en">
                            <img class="lang-flag" src="${pageContext.request.contextPath}/resources/core/img/flags/ru.png"/>
                        </a></li>
                    </ul>
                </li>

                <li><a href="#" data-toggle="modal" data-target="#login_dialog">
                    <spring:message code="menu.login"/></a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="jumbotron">
    <div class="container">
        <h1>${title}</h1>
        <p>
            <c:if test="${not empty name}">
                Hello ${name}
            </c:if>

            <c:if test="${empty name}">
                Welcome Welcome!
            </c:if>
        </p>
        <p>
            <a class="btn btn-primary btn-lg" href="#" role="button">Learn more</a>
        </p>
    </div>
</div>

<div class="container">

    <div class="row">
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
        <p>&copy; 2017 Andrej Istomin. <spring:message code="credit.text"/> <a rel="nofollow" href="https://www.vecteezy.com">vecteezy.com</a>, <a rel="nofollow" href="https://dribbble.com/msenyil">Muharrem Şenyıl</a></p>
    </footer>
</div>

<spring:url value="/resources/core/js/musicist.js" var="coreJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>