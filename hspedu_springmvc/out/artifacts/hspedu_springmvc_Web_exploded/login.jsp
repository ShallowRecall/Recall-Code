<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/6
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>
<h3>登录页面</h3>
<%--
解读：
1. action="login" 表示url 是 http://localhost:8080/springmvc/login
2. action="/login" 表示url 是 http://localhost:8080/login
--%>
<form action="login">
    u:<input name="username" type="text"> <br>
    p:<input name="password" type="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
