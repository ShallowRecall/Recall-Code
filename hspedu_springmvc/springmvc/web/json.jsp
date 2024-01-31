<%--
  Created by IntelliJ IDEA.
  User: zhouyu
  Date: 2024/1/24
  Time: 22:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>json提交</title>
    <%-- 引入jquery --%>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>

    <%-- 编写jquery代码和请求 --%>
    <script type="text/javascript">
        $(function () {
            // 给id="getJson"绑定点击事件
            $("#getJson").click(function () {
                //console.log("ok ....")

                var url = this.href;
                var args = {"time": new Date}; // 这是要发送数据，为了防止页面缓存
                $.post(
                    url,
                    args,
                    function (data) {//data 就是返回的数据，是json格式=>如果是多个json数据，可以遍历
                        console.log("data= ", data);
                        console.log("dog.name=", data.name)
                        console.log("dog.address=", data.address)
                    },
                    "json"
                );

                return false;//这里我们返回false，就不使用href默认机制
            })

            //绑定按钮点击事件，提交json数据
            //springmvc 可以在后台将json转成对象
            $("button[name='butt1']").click(function () {
                // 目标:将userName 和 age 封装成json字符串，发送给目标方法
                var url = "/springmvc/save2";
                var userName = $("#userName").val();
                var age = $("#age").val();
                //将json对象转成json字符串
                var args = JSON.stringify({"userName": userName, "age": age});
                $.ajax({
                    url: url,
                    data: args,
                    type: "POST",
                    success: function (data) {
                        console.log("返回的data= ", data);
                    },
                    // 下面这个contentType参数，是指定发送数据时的编码和格式
                    contentType: "application/json;charset=utf-8"
                })
            })
        })
    </script>

</head>
<body>
<h1>请求一个json数据</h1>
<%--
1. 当用户点击超链接时，我们发出ajax请求
2. 接收到请求后，我们查看这个json数据
3. 使用jquery发出ajax请求的知识
--%>
<a href="<%=request.getContextPath()%>/json/dog" id="getJson">点击获取json数据</a>

<h1>发出一个json数据</h1>
u:<input id="userName" type="text"><br/>
a:<input id="age" type="text"><br/>
<button name="butt1">添加用户</button>

<h1>下载文件的测试 </h1>
<a href="<%=request.getContextPath()%>/downFile">点击下载文件</a>
</body>
</html>
