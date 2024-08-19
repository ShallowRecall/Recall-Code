package com.hspedu.seckill.web;

import com.hspedu.seckill.redis.SecKillRedis;
import com.hspedu.seckill.redis.SecKillRedisByLua;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.util.Random;

public class SecKillServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 请求时，模拟生成一个userId
        String userId = new Random().nextInt(10000) + "";
        //2. 获取用户要购买的票的编号
        String ticketNo = req.getParameter("ticketNo");

        //3. 调用秒杀的方法
        //boolean isOk = SecKillRedis.doSecKill(userId, ticketNo);

        //4. 调用lua脚本完成秒杀方法
        boolean isOk = SecKillRedisByLua.doSecKill(userId, ticketNo);

        //4.将结果返回给前端-这个地方可以根据业务需求调整
        resp.getWriter().print(isOk);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }
}
