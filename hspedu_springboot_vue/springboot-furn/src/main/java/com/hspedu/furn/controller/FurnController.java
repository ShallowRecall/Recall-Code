package com.hspedu.furn.controller;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.service.FurnService;
import com.hspedu.furn.util.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 * 说明
 * 1. 因为当前项目是前后端分离的，在默认情况下，前端发出请求
 * 2. 后端，返回一个json数据，为了方便，我们就在类上使用@RestController
 */
@RestController
@Slf4j
public class FurnController {

    // 装配Service
    @Resource
    private FurnService furnService;

    //编写方法，完成添加
    //说明
    //1. 我们前端如果是以json格式来发送添加信息furn，那么我们需要使用@RequestBody，
    //  ，才能将数据封装到对应的bean，同时保证我们http的请求头 content-type是对应的
    //2. 如果前端是以表单形式提交的，则不需要使用@RequestBody，才会进行对象参数的封装，同时要保证
    //   http的请求头 content-type是对应的

    // 编写方法，完成添加
    @PostMapping("/save")
    public Result save(@RequestBody Furn furn) {

        log.info("furn={}", furn);
        furnService.save(furn);

        return Result.success(); // 返回成功信息
    }

    // 返回所有的家居信息
    @RequestMapping("/furns")
    public Result listFurns() {
        List<Furn> furns = furnService.list();
        return Result.success(furns);
    }

    // 处理修改

    /**
     * 说明：
     * 1. @PutMapping 我们使用Rest风格，因为这里是修改的请求，使用put请求
     * 2. @RequestBody：表示前端/客户端 发生的数据是以json格式来发送
     *
     * @param furn
     * @return
     */
    @PutMapping("/update")
    public Result update(@RequestBody Furn furn) {
        //这个updateById是mybatis-plus提供的
        furnService.updateById(furn);
        return Result.success();
    }
}
