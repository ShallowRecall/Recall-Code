package com.hspedu.web.homework;

import com.hspedu.web.homework.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RequestMapping("/user")
@Controller
public class LoginHandler {

    // 处理登录
    @RequestMapping(value = "/login")
    public String doLogin(User user) {
        //判断
        if ("hsp".equals(user.getUsername())
                && "123".equals(user.getPassword())) {
            //验证OK
            return "forward:/WEB-INF/pages/homework/login_ok.jsp";
        }else {
            return "forward:/WEB-INF/pages/homework/login_error.jsp";
        }
    }
}
