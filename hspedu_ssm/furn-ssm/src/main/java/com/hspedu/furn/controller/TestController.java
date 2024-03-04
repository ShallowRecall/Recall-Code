package com.hspedu.furn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/hi")
    public String hi(){
        System.out.println("TestController-hi");
        return "hi";
    }
}
