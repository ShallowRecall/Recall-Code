package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
public class MemberConsumerFeignController {

    //装配MemberFeignService
    @Resource
    private MemberFeignService memberFeignService;

    @GetMapping(value = "/member/consumer/openfeign/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id) {
        return memberFeignService.getMemberById(id);
    }
}
