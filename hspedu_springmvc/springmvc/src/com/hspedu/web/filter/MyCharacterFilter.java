package com.hspedu.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 * 编写过滤器，处理中文乱码
 */
public class MyCharacterFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        //这里加入对编码的处理
        servletRequest.setCharacterEncoding("utf-8");
        //放行请求，和JavaWeb中的过滤器一样
        filterChain.doFilter(servletRequest, servletResponse);

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
