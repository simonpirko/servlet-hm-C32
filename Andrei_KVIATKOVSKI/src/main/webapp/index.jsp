<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 31.05.2020
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <h1>Hello ${sessionScope.currentUser.name}! It's Web Calculator ver 1.2</h1>
    <a href="/reg">Registration  |</a>
    <a href="/auth">Authorisation  |</a>
    <a href="/history">History  |</a>
    <a href="/main">Calculator  |</a>
    <a href="/logout">Logout  |</a>
</head>
<body>

</body>
</html>
