package com.hspedu.springboot.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {

    /**
     * 目标方法执行前被调用.
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String requestURI = request.getRequestURI();
        String requestURL = request.getRequestURL().toString();
        log.info("preHandle拦截到的请求的URI={}", requestURI);
        log.info("preHandle拦截到的请求的URL={}", requestURL);

        // 进行登录的校验
        HttpSession session = request.getSession();
        Object loginAdmin = session.getAttribute("loginAdmin");

        if (null != loginAdmin){//说明该用户已经成功登录
            //放行
            return true;
        }
        //拦截，重新返回到登录页面
        request.setAttribute("msg", "你没有登录/请登录~~");
        request.getRequestDispatcher("/").forward(request,response);

        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle方法执行了~~");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion方法执行了~~");
    }
}
