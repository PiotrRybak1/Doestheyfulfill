<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PoliticalParty Form</title>
</head>
<body>
<nav>
    <jsp:include page="navLinks.jsp"/>
</nav>
<form:form method="post" action="/politician/add" modelAttribute="politicianAdd">
    <label for="firstName">firstName</label>
    <form:input path="firstName" id ="firstName" required="true"/>
    <label for="lastName">lastName</label>
    <form:input path="lastName" id ="lastName" required="true"/>
    <label for="dayOfBirth">dayOfBirth</label>
    <form:input path="dayOfBirth" id ="dayOfBirth" required="true"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>