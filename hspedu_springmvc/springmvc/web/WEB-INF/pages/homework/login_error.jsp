<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/22
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录失败</title>
</head>
<body>
<h1>登录失败</h1>
<%--解读
1. 这里考察web工程路径的知识点
2. <%=request.getContextPath()%>/homework/login.jsp 解析
   /springmvc/homework/login.jsp
3. 浏览器会解析 第一个 / 为 http://localhost:8080/springmvc/homework/login.jsp
--%>
<a href="<%=request.getContextPath()%>/homework/login.jsp">返回重新登录</a>
</body>
</html>
