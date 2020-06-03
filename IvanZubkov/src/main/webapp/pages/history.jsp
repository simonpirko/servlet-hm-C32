<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>>

<html>
<head>
    <title>History</title>
</head>
<body>

<h2>${"History"}</h2>

<form action="history.jsp">
    <select name="sort">
        <option value="increase">Increase</option>
        <option value="decrease">Increase</option>
    </select>
    <button>Start sort</button>

</form>

<ul style="list-style: decimal">
    <c:forEach items="${requestScope.sorteredList}" var="item">
        <li>${item}</li>
    </c:forEach>
</ul>

<a href="/">main</a>

</body>
</html>
