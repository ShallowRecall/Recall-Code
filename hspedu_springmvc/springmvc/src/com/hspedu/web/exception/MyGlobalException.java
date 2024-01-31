package com.hspedu.web.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ZhouYu
 * @version 1.0
 */

/**
 * 如果一个类上标注了@ControllerAdvice，就是一个全局异常处理类
 */
@ControllerAdvice
public class MyGlobalException {

    /**
     * 解读
     * 1. 全局异常就不管是哪个Handler抛出的异常，都可以捕获，@ExceptionHandler({异常类型})
     * 2. 这里处理的全局异常是NumberFormatException.class, ClassCastException.class
     * 3. Exception ex 接收抛出的异常对象
     * @return
     */
    //
    @ExceptionHandler({NumberFormatException.class, ClassCastException.class, AgeException.class})
    public String globalException(Exception ex, HttpServletRequest request){
        System.out.println("全局异常处理-"+ex.getMessage());
        // 如何将异常的信息带到下一个页面.
        request.setAttribute("reason", ex.getMessage());
        return "exception_mes";
    }
}
