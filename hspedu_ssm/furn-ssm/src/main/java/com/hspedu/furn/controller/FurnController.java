package com.hspedu.furn.controller;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.bean.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class FurnController {
    // 响应客户端的添加请求

    /**
     * 1、响应客户端的添加请求
     * 2、@RequestBody：
     * @param furn
     * @return
     */
    @PostMapping("/save")
    public Msg save(@RequestBody Furn furn){

    }
}
