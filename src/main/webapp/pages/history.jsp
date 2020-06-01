<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 31.05.2020
  Time: 20:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>History</title>
</head>
<body>
<form action="/main">
    <button>Back</button>
</form>
<h2>${"History"}</h2>

<ul style="list-style: decimal">

    <%
        List <String> all_operation = (List) request.getSession().getAttribute("str");
        for (int i = 0; i < all_operation.size(); i++) {
            out.println ( "<li>" + all_operation.get(i) + "</li>" );
        }
    %>
</ul>
</body>
</html>
