package com.hspedu.springboot.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.HandlerMethod;

/**
 * @author ZhouYu
 * @version 1.0
 * @ControllerAdvice：使用它可以标识一个全局异常处理器/对象 会被注入到spring容器
 */
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    //1、编写方法处理，处理指定的异常,比如我们处理算术异常和空指针异常，可以指定多个异常
    //2、这里要处理的异常，有程序员来指定
    //3、Exception e ：表示异常发生后传递的异常对象
    //4、Model model ：可以将我们的异常信息，放入到model，并传递给显示页面

    // 提出一个问题，如何获取到异常发生的方法

    @ExceptionHandler({ArithmeticException.class, NullPointerException.class})
    public String handleAritException(Exception e, Model model, HandlerMethod handlerMethod) {

        log.info("异常信息={}", e.getMessage());
        //将异常信息，放入到model中,可以在错误页面取出显示
        model.addAttribute("msg", e.getMessage());
        //得到异常发生的方法是哪个
        log.info("异常发生的方法是：{}", handlerMethod.getMethod());
        return "/error/global"; // 视图地址
    }
}
