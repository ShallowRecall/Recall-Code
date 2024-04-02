package com.hspedu.springboot.mybatis.controller;

import com.hspedu.springboot.mybatis.bean.Monster;
import com.hspedu.springboot.mybatis.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class MonsterController {

    //装配一个MonsterService
    @Resource
    private MonsterService monsterService;

    @ResponseBody
    @GetMapping("monster")
    public Monster getMonsterById(@RequestParam(value = "id") Integer id){

        return monsterService.getMonsterById(id);
    }
}
