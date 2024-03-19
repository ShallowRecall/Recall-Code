package com.hspedu.springboot.servlet;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 * 开发Filter 并注入
 *
 *
 * 解读
 * 1. @WebFilter 表示Filter_ 是一个过滤器，并注入容器
 * 2. urlPatterns = {"/css/*", "images/*"} 当请求 /css/目录资源或者 /images/目录下资源的时候，会经过该过滤器
 * 3. 是直接放行后，再经过拦截器，拦截器是否拦截要根据拦截器的拦截规则
 */
@Slf4j
@WebFilter(urlPatterns = {"/css/*","/images/*"})
public class Filter_ implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("--Filter_ init--");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("--Filter_ doFilter--");
        // 为了方便观察过滤器处理的资源，我们输出一个uri
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        log.info("过滤器处理的uri={}", httpServletRequest.getRequestURI());
        // 直接放行
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
