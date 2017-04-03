<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>MusicIST Project</title>
    <spring:url value="/resources/core/css/musicist.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>
</head>
<body>
<div class="modal fade" tabindex="-1" role="dialog" id="login_dialog">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">

            <div class="modal-header">
                <div class="row">
                    <div class="col-xs-9"><h3 class="modal-title one-line" id="myModalLabel">Hello Title!</h3></div>
                    <div class="col-xs-3"><button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>
                </div>
            </div><!-- /.modal-header -->

            <div class="modal-body">
                Hello!
            </div><!-- /.modal-body -->
        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
        </div>
        <a class="navbar-brand" href="#">MusicIST Project</a>
        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#login_dialog">Log In</a></li>
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
        <p>&copy; Andrej Istomin 2017</p>
    </footer>
</div>

<spring:url value="/resources/core/js/musicist.js" var="coreJs"/>
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</body>
</html>