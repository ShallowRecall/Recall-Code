package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Admin;
import com.hspedu.springboot.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
@Slf4j
public class AdminController {

    // 响应用户的登录请求
    @PostMapping("/login")
    public String login(Admin admin, HttpSession session, Model model) {

        // 验证用户是否合法
        if (StringUtils.hasText(admin.getName()) && "666".equals(admin.getPassword())) {

            // 将登录用户保存到session
            session.setAttribute("loginAdmin", admin);

            // 合法，重定向到mange.html
            // 不使用请求转发是防止刷新页面会重复提交
            // 这里写 manage.html，因为这样可以更加明确的表示到哪个页面
            //manage.html 表示要去找 方法的映射路径为 manage.html
            return "redirect:/manage.html";
        } else {
            //不合法，就重新登录，请求转发
            model.addAttribute("msg", "账号/用户错误");
            return "adminLogin";
        }
    }

    // 处理用户的请求到 manage.html
    @GetMapping("/manage.html")
    public String mainPage(Model model, HttpSession session) {

/*        Object loginAdmin = session.getAttribute("loginAdmin");

        if (null != loginAdmin) {// 说明成功登录过
            // 可以这里集合- 模拟用户数据，放入到request域中，并显示
            ArrayList<User> users = new ArrayList<>();
            users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
            users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
            users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
            users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
            users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));

            //将数据放入到request域中
            model.addAttribute("users", users);

            return "manage"; //这里才是我们的视图解析到 /template/manage.html
        }else {
            // 这里就返回登录页，并给出提示
            model.addAttribute("msg","你没有登录/请登录");
            return "adminLogin";//请求转发到adminLogin.html
        }*/

        log.info("进入mainPage()");
        // 可以这里集合- 模拟用户数据，放入到request域中，并显示
        ArrayList<User> users = new ArrayList<>();
        users.add(new User(1, "关羽~", "666666", 20, "gy@sohu.com"));
        users.add(new User(2, "张飞", "666666", 30, "zf@sohu.com"));
        users.add(new User(3, "赵云", "666666", 22, "zy@sohu.com"));
        users.add(new User(4, "马超", "666666", 28, "mc@sohu.com"));
        users.add(new User(5, "黄忠", "666666", 50, "hz@sohu.com"));

        //将数据放入到request域中
        model.addAttribute("users", users);

        return "manage"; //这里才是我们的视图解析到 /template/manage.html
    }
}
