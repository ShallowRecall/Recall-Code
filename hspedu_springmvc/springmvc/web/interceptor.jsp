<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/29
  Time: 16:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试自定义拦截器</title>
</head>
<body>
<h1>测试自定义拦截器</h1>
<a href="<%=request.getContextPath()%>/hi">测试自定义拦截器-hi</a><br><br>
<a href="<%=request.getContextPath()%>/hello">测试自定义拦截器-hello</a><br><br>
<a href="<%=request.getContextPath()%>/ok">测试自定义拦截器-ok</a>
</body>
</html>
