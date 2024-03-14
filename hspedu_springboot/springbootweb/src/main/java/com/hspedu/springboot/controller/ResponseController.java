package com.hspedu.springboot.controller;

import com.hspedu.springboot.bean.Car;
import com.hspedu.springboot.bean.Monster;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class ResponseController {

    // 返回Monster数据-要求以json格式返回
    @GetMapping("/get/monster")
    @ResponseBody
    public Monster getMonster() {

        // 开发中，monster对象是从DB获取-这里是模拟一个Monster对象
        Monster monster = new Monster();
        monster.setId(100);
        monster.setName("奔波霸");
        monster.setAge(200);
        monster.setIsMarried(false);
        monster.setBirth(new Date());
        Car car = new Car();
        car.setName("奔驰");
        car.setPrice(222.2);
        monster.setCar(car);
        return monster;
    }
}
