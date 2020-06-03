<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>

<head>
    <style>
        .breadcrumbs {
            margin: 0; /* Убираем отступы */
            padding: 10px; /* Поля вокруг текста */
            background: #b2d235; /* Цвет фона */
        }
        .breadcrumbs li {
            display: inline-block; /* Размещаем список по горизонтали */
        }
        .breadcrumbs a {
            color: #000000; /* Цвет ссылок */
            text-decoration: underline black;
        }
        .breadcrumbs li + li::before {
            content: '/'; /* Разделитель ссылок */
            padding: 0 7px; /* Расстояние вокруг разделителя */
        }
    </style>

</head>
<body>
<h2>${requestScope.messageHello}</h2>


<ul class="breadcrumbs">
<c:if test="${!sessionScope.checkAuth}">
    <li><a href="/reg">Registration</a></li>
    <li><a href="/auth">Authorization</a></li>
</c:if>
    <c:if test="${sessionScope.checkAuth}">
    <li><a href="/calc">Calculation</a></li>
    <li><a href="/history">History</a></li>
    <li><a href="/logout">Logout</a></li>
    </c:if>
</ul>

<h4>${requestScope.message}</h4>
</body>
</html>
