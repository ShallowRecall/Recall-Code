package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class IndexController {

    // 编写方法，转发到登录页面
    @GetMapping(value = {"/","/login"})
    public String login(){
        /**
         * 解读
         * 1. 因为我们引入了starter-thymeleaf
         * 2. 这里就会直接使用视图解析到 thymeleaf下的模版文件adminLogin.html
         */
        return "adminLogin";
    }
}
