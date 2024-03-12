package com.hspedu.hspspringboot.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
public class HspHiController {

    @RequestMapping("/hsphi")
    public String hi(){
        return "hi,hsp HspHiController";
    }
}
