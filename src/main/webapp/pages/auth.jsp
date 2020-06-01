<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 25.05.2020
  Time: 21:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Auth</title>
</head>
<body>
<form action="/auth" method="post">
    <input type="text" name="login" placeholder="Login">
    <input type="text" name="password" placeholder="Password">
    <button>Submit</button>
</form>
${requestScope.massage}
</body>
</html>
