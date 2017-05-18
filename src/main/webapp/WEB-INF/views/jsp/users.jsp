<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title><spring:message key="users.management"/></title>
</head>
<body>
<h1><spring:message key="users.management"/></h1>

<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.username}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/delete/${user.id}"><spring:message key="users.delete"/></a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty users}">
        no users added yet.
    </c:if>
</table>

<a href="${pageContext.request.contextPath}/users/add"><spring:message key="users.add"/></a>
</body>
</html>
