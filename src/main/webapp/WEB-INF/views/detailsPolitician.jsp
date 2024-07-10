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
        <th>promises</th>
    </tr>

    <tr>
        <td>${politicianDetails.firstName}</td>
        <td>${politicianDetails.lastName}</td>
        <td>${politicianDetails.dayOfBirth}</td>
        <td>${politicianDetails.party}</td>
        <td>${politicianDetails.position}</td>
        <c:forEach items="politicianDetails" var = "promise">
        <td>
            <p>${promise.titleOfPromise}</p>
        </td>
    </tr>
</table>

</body>
</html>