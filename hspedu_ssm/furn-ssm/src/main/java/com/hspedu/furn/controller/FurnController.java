package com.hspedu.furn.controller;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.bean.Msg;
import com.hspedu.furn.service.FurnService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Controller
public class FurnController {

    //注入配置FurnService
    @Resource
    private FurnService furnService;
    /**
     * 1、响应客户端的添加请求
     * 2、@RequestBody：使用 SpringMVC 的 @RequestBody 将客户端提交的 json，封装成JavaBean对象
     * 3、@ResponseBody：服务器返回的数据格式是按照 json 来返回的(底层是按照http协议进行协商)
     * @param furn
     * @return
     */
    @PostMapping("/save")
    @ResponseBody
    public Msg save(@RequestBody Furn furn){
        furnService.save(furn);
        //返回成功
        return Msg.success();
    }

    @RequestMapping("/furns")
    @ResponseBody
    public Msg listFurns(){
        List<Furn> furnList = furnService.findAll();
        // 把家居信息，封装到msg对象
        return Msg.success().add("furnList",furnList);
    }

    @PutMapping("update")
    @ResponseBody
    public Msg update(@RequestBody Furn furn){
        furnService.update(furn);
        return Msg.success();
    }

    @DeleteMapping("/del/{id}")
    @ResponseBody
    public Msg del(@PathVariable Integer id){
        furnService.del(id);
        return Msg.success();
    }
}
