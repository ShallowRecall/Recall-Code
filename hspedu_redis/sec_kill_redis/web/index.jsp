<%--
  Created by IntelliJ IDEA.
  User: Zhou Yu
  Date: 2024/8/18
  Time: 18:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
    <base href="<%=request.getContextPath() + "/"%>">
</head>
<body>
<h1>北京-成都 火车票 ! 秒杀！
</h1>


<form id="secKillform" action="secKillServlet" enctype="application/x-www-form-urlencoded">
    <input type="hidden" id="ticketNo" name="ticketNo" value="bj_cd">
    <input type="button" id="seckillBtn" name="seckillBtn" value="秒杀火车票【北京-成都】"/>
</form>

</body>
<script type="text/javascript" src="script/jquery/jquery-3.1.0.js"></script>
<script type="text/javascript">
    $(function () {
        $("#seckillBtn").click(function () {
            var url = $("#secKillform").attr("action");
            console.log("url->" , url)// secKillServlet,完整的url http://localhost:8080/seckill/secKillServlet
            console.log("serialize->", $("#secKillform").serialize())
            //
            $.post(url, $("#secKillform").serialize(), function (data) {
                if (data == "false") {
                    alert("火车票 抢光了:)");
                    $("#seckillBtn").attr("disabled", true);
                }
            });
        })
    })
</script>
</html>