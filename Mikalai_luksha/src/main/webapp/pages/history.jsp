<%@ page import="java.util.List" %>
<%@ page import="entity.Operation" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>History</title>
</head>
<body>

<h2>"History"</h2>

<form action="/history">
    <label>
        <select name="operation">
            <option value="all">all</option>
            <option value="plus">plus</option>
            <option value="minus">minus</option>
            <option value="times">times</option>
            <option value="div">div</option>
        </select>
    </label>
    <label>
        <select name="sort">
            <option value="asc">  ASC  </option>
            <option value="desc">  DESC  </option>
        </select>
    </label>
    <button>Sort</button>
</form>


<ul style="list-style: decimal">

<c:forEach items="${requestScope.resHis}" var="res">
<li>${res}</li>
</c:forEach>
</ul>

</body>

<a href="/">main</a>
</html>
