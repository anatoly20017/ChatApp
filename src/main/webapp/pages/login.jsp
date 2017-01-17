<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mrhri
  Date: 14.01.2017
  Time: 16:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
</head>
<body>

    <div class="main">
        <div class="login-form">

            <form action="/login" method="post" class="forma_reg">
                <ul>
                    <p class="error">${error}</p>
                    <li class="input"><label>Введите логин <input class="in" type="text" name="login" placeholder="Введите логин"></label></li>
                    <li class="input"><label>Введите пароль <input class="in" type="password" name="password" placeholder="от 3 до 16 символов"></label></li>
                    <li class="input"><button class="btn_enter" type="submit">Вход</button></li>
                </ul>

            </form>
        </div>
    </div>

</body>
</html>
