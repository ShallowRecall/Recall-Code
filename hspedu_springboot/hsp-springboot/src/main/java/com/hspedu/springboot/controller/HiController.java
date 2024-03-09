package com.hspedu.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhouYu
 * @version 1.0
 *
 * 因为
 * 1. HiController 被 @RestController标注，就是一个控制器
 * 2. HiController 在扫描包/子包，会被注入spring容器
 */
@RestController
public class HiController {

    @RequestMapping("/hi")
    public String hi(){
        return "hi hsp HiController";
    }
}
