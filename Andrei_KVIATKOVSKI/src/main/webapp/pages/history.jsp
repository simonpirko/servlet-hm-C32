<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<form action="/" >
    <button>Back to the main page</button>
</form>

<ul style="list-style: decimal">
    <c:forEach items="${requestScope.sum1}" var="resultOperation">
        <li>${resultOperation}</li>
    </c:forEach></ul>
</body>
</html>
