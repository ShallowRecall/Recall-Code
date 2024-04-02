package com.hspedu.springboot.mybatisplus.controller;

import com.hspedu.springboot.mybatisplus.bean.Monster;
import com.hspedu.springboot.mybatisplus.service.MonsterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class MonsterController {

    @Resource
    private MonsterService monsterService;

    @GetMapping("/monster")
    @ResponseBody
    //方法，根据id返回对应对象
    public Monster getMonsterById(@RequestParam(value = "id") Integer id) {
        return monsterService.getById(id);
    }

    //编写方法，返回所有的monster信息
    @GetMapping("/list")
    @ResponseBody
    public List<Monster> listMonster(){
        return monsterService.list();
    }
}
