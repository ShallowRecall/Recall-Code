package com.hspedu.springboot.controller;

import com.hspedu.springboot.exception.AccessException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class MyErrorController {

    // 模拟一个服务器错误500
    @GetMapping("/err")
    public String err() {
        int i = 10 / 0;
        return "manage";
    }

    // 这里我们配置的是Post方式请求 /err2
    // 使用 get 方式来请求 /err2 , 这样就会出现一个4开头的客户端错误
    @PostMapping("/err2")
    public String err2() {
        // ..
        return "manage";
    }

    //编写方法，模拟一个AccessException
    @GetMapping("/err3")

    public String err3(String name){

        // 如果用户不是tom，我们就认为，无权访问
        if (!"tom".equals(name)){
            //throw  new AccessException();
            throw  new AccessException("自定义的AccessException..");
        }
        return "manage";//视图地址，请求转发
    }
}
