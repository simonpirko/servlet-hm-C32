<%--
  Created by IntelliJ IDEA.
  User: andre
  Date: 25.05.2020
  Time: 21:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Calculator</title>
</head>
<body>
<form action="/main" method="post">
    <input type="text" name="num1" placeholder="Number1">
    <input type="text" name="num2" placeholder="Number2">
    <select name="operation">
        <option value="sum">+</option>
        <option value="minus">-</option>
        <option value="multiply">*</option>
        <option value="div">/</option>
    </select>
    <button>Calc</button>
</form>
Result = ${requestScope.resultOperation}
<form action="/">
    <button>Exit in Menu</button>
</form>
<form action="/history">
    <button>ShowHistory</button>
</form>
</body>
</html>
