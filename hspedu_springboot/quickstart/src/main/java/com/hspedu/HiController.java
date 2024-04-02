package com.hspedu;

import com.hspedu.springboot.bean.Furn;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Slf4j
@Controller
public class HiController {

    // 需求website 属性值从application.properties 的k-v
    @Value("${my.website}")
    private String website;

    //装配到HiController
    @Resource
    private Furn furn;

    // 返回hi,springboot
    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        System.out.println("website~" + website);
        return "hi~,SpringBoot";
    }

    @RequestMapping("/furn")
    @ResponseBody
    public Furn furn() {
        //System.out.println("furn--" + furn);
        //使用slf4j日志输出
        // 普通方式
        log.info("furn--" + furn);
        // 占位符方式输出
        log.info("furn={} myfurn={}",furn,furn);
        return furn;
    }

}
