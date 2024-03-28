package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
@Slf4j
public class MemberConsumerController {

    // 定义member_service_provider_url 这是一个基础的url地址

    //command + shift + U 切换大小写
    public static final String MEMBER_SERVICE_PROVIDER_URL =
            "http://localhost:10000"; //后面这个地方会修改成提供服务的注册别名
    //装配RestTemplate
    @Resource
    private RestTemplate restTemplate;

    // 方法/接口 添加member对象到数据库/表
    @PostMapping("/member/consumer/save")
    public Result save(Member member) {
        log.info("service-consumer member={}", member);
        //说明
        //请求的完整的url：MEMBER_SERVICE_PROVIDER_URL+"/member/save" =>  http://localhost:10000/member/save
        //member：就是通过restTemplate 发出的post请求携带的数据(对象)
        //Result.class：返回对象类型
        //这里通过restTemplate 调用服务提供模块的接口，就是一个远程调用 RPC
        return restTemplate.postForObject(MEMBER_SERVICE_PROVIDER_URL
                + "/member/save", member, Result.class);
    }

    // 方法/接口 ，根据id 调用服务接口，返回member对象信息

    @GetMapping("/member/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {

        return restTemplate.getForObject(
                MEMBER_SERVICE_PROVIDER_URL + "/member/get/" + id, Result.class);
    }

}
