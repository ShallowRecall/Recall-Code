<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/22
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加妖怪</title>
</head>
<body>
<h3>添加妖怪</h3>
<%-- 这里的表单，我们使用SpringMVC的标签来完成
特别说明几点：
1. SpringMVC 表单标签在显示之前必须在 request 中有一个 bean，该 bean 的属性和表单标签的字段要对应！
request 中的 key 为：form 标签的 modelAttribute 属性值，比如这里的monsters
2. SpringMVC 的 form:form 标签的 action 属性值中的 / 不代表 WEB 应用的根目录.
3. 这里使用springmvc的标签的主要的目的是方便提示信息回显
--%>
<form:form action="save" method="post" modelAttribute="monster">
    妖怪名字：<form:input path="name"/> <br><br>
    妖怪年龄~：<form:input path="age"/> <br><br>
    电子邮件：<form:input path="email"/> <br><br>
    妖怪生日：<form:input path="birthday"/> 要求以"9999-11-11"的形式<br><br>
    妖怪薪水：<form:input path="salary"/> 要求以"123,890.12"的形式<br><br>
    <input type="submit" value="添加妖怪"/>
</form:form>
</body>
</html>
