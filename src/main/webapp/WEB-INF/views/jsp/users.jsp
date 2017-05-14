<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Database test.</title>
</head>
<body>
<h1>User management</h1>

<table>
    <c:forEach var="user" items="${users}">
        <tr>
            <td>
                <c:out value="${user.username}"/>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/users/delete/${user.id}">Add new user</a>
            </td>
        </tr>
    </c:forEach>
    <c:if test="${empty users}">
        no users added yet.
    </c:if>
</table>

<a href="${pageContext.request.contextPath}/users/add">Add new user</a>
</body>
</html>
