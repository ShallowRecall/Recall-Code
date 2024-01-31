<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/30
  Time: 10:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>异常信息</title>
</head>
<body>
<h1>测试异常</h1>
<a href="<%=request.getContextPath()%>/testException01?num=0">点击测试局部异常</a><br><br>
<a href="<%=request.getContextPath()%>/testGlobalException">点击测试全局异常</a><br><br>
<a href="<%=request.getContextPath()%>/testException02">点击测试自定义异常</a><br><br>
<a href="<%=request.getContextPath()%>/testException03">点击测试统一处理异常</a><br><br>
<a href="<%=request.getContextPath()%>/testException04">点击测试未知异常</a><br><br>
</body>
</html>
