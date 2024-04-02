package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Monster;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
public class HiController {

    @Resource
    private Monster monster;

    @RequestMapping("/monster")
    public Monster monster() {
        return monster;
    }
}
