package com.hspedu.springboot.controller;

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

}
