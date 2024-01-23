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
<%--解读
1. <%=request.getContextPath()%>/user/login => /springmvc/user/login
2. /springmvc/user/login => http://localhost:8080/springmvc/user/login
--%>
<form action="<%=request.getContextPath()%>/user/login" method="post">
    u:<input name="username" type="text"> <br>
    p:<input name="password" type="password"> <br>
    <input type="submit" value="登录">
</form>
</body>
</html>
