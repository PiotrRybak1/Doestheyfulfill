<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Politicians</title>
</head>
<body>
<nav>
    <jsp:include page="navLinks.jsp"/>
</nav>
<table>
    <tr>
        <th>firstName</th>
        <th>lastName</th>
        <th>dayOfBirth</th>
        <th>party</th>
        <th>position</th>
        <th>details</th>
    </tr>
    <c:forEach items="${allPoliticians}" var="value">
    <tr>
        <td>${value.firsName}</td>
        <td>${value.lastName}</td>
        <td>${value.dayOfBirth}</td>
        <td>${value.party}</td>
        <td>${value.position}</td>
        <td><a href="/${pageContext.request.contextPath}/${value.id}"><button type="submit">details</button></a></td>
        </c:forEach>
</tr>
</table>

</body>
</html>