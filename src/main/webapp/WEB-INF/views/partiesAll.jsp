<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Parties</title>
</head>
<body>
<nav>
    <jsp:include page="navLinks.jsp"/>
</nav>
<table>
    <tr>
        <th>name</th>
        <th>description</th>



    </tr>

    <c:forEach items="${allParties}" var="value">
        <tr>
            <td>${value.name}</td>
            <td>${value.description}</td>

    </c:forEach>

</table>

</body>
</html>