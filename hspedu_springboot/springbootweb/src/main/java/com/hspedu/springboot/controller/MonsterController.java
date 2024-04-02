package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class MonsterController {

    //等价写法
    //@RequestMapping(value = "/monster",method = RequestMethod.GET)
    @GetMapping("/monster")
    public String getMonster(){
        return "GET-查询妖怪";
    }

    //等价写法
    //@RequestMapping(value = "/monster",method = RequestMethod.POST)
    @PostMapping("/monster")
    public String saveMonster(){
        return "POST-添加妖怪";
    }

    //等价写法
    //@RequestMapping(value = "/monster",method = RequestMethod.PUT)
    @PutMapping("/monster")
    public String putMonster(){
        return "PUT-修改妖怪";
    }

    //等价写法
    //@RequestMapping(value = "/monster",method = RequestMethod.DELETE)
    @DeleteMapping("/monster")
    public String delMonster(){
        return "DELETE-删除妖怪";
    }

    @RequestMapping("/go")
    public String go(){
        return "hello"; //注意 1. 看 controller有没有 /hello[没有配置视图解析器] 2. 如果配置了视图解析器，就按照视图解析器来定位页面
    }


}
