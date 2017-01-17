<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: mrhri
  Date: 14.01.2017
  Time: 16:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>ChatApp</title>
    <link href="<c:url value="resources/css/style.css" />" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="resources/css/font-awesome/css/font-awesome.min.css"/>">
  </head>
  <body>

  <div class="header">
    <div class="logo"></div>
    <a class="btn_enter" href="/login">Вход</a>
    <a class="btn_reg" href="/registration"><i class="fa fa-info" aria-hidden="true"> </i> Информация для регистрации пользователя</a>
  </div>
  <div class="welcome">
    <div><p>Добро пожаловать на сайт</p></div>
    <img src="resources/images/CHATAPP.png">
    <div class="welcome-chat"><p>чат с моментальным переводом текста!</p></div>
    <div class="welcome-friends"><p>лучшее решение для тех кто имеет иностранных друзей</p></div>
  </div>
  <div class="btn_wrap">

  </div>

  </body>
</html>
