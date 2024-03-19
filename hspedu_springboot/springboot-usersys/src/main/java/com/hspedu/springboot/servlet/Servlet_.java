package com.hspedu.springboot.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 * 解读
 * 1. 通过继承 HttpServlet 来开发原生的Servlet
 * 2. @WebServlet 标识将 Servlet_ 对象/bean注入到容器
 * 3. urlPatterns = {"/servlet01","/servlet02"}，对servlet配置了url-pattern
 * 4. 提示：注入的原生的Servlet_ 不会被spring-boot的拦截器拦截
 * 5. 对于开发的原生的Servlet，需要使用 @ServletComponentScan指定要扫描的原生Servlet包
 * ，才会注入到spring 容器.
 */
//@WebServlet(urlPatterns = {"/servlet01","/servlet02"})
public class Servlet_ extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("hello,Servlet_!");
    }
}
