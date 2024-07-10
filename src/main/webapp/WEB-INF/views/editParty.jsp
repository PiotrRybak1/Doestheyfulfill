<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>PoliticalParty Form</title>
</head>
<body>
<nav>
    <jsp:include page="navLinks.jsp"/>
</nav>
<form:form method="post" action="/politicalParty/edit" modelAttribute="partyToEdit">
    <form:hidden path="id" />
    <label for="name">name</label>
    <form:input path="name" id ="name" required="true"/>
    <label for="description">description</label>
    <form:input path="description" id ="description" required="true"/>
    <button type="submit">Submit</button>
</form:form>
</body>
</html>