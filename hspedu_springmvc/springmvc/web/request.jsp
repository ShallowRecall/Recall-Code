<%--
  Created by IntelliJ IDEA.
  User: Zhou Yu
  Date: 2024/1/14
  Time: 16:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购买商品</title>
</head>
<body>
<h1>购买商品</h1>
<%--解读：
1. action="user/buy" 对应 url http://localhost:8080/工程路径/user/buy
--%>
<form action="user/buy" method="post">
    购买人：<input type="text" name="username"><br>
    购买量：<input type="text" name="nums"><br>
    <input type="submit" value="购买">
</form>


<hr><h1>演示params的使用</h1>
<a href="user/find?bookId=200">查询书籍</a>

<hr><h1>演示Ant风格的请求资源方法</h1>
<a href="user/message/aa">发送消息1</a><br>
<a href="user/message/aa/bb/cc">发送消息2</a><br>

<hr><h1>占位符的演示</h1>
<a href="user/reg/kristina/300">占位符的演示</a>
</body>
</html>
