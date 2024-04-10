package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberOpenFeignService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
@Slf4j
public class MemberNacosConsumerController {

    //http://member-service-nacos-provider 就是服务注册到Nacos server的服务名，这里是小写
    public static final String MEMBER_SERVICE_NACOS_PROVIDER_URL =
            "http://member-service-nacos-provider";

    //配置RestTemplate
    @Resource
    private RestTemplate restTemplate;

    //装配MemberOpenFeignService
    @Resource
    private MemberOpenFeignService memberOpenFeignService;

    //编写方法通过openfeign实现远程调用
    @GetMapping("/member/openfeign/consumer/get/{id}")
    public Result<Member> getMemberOpenfeignById(@PathVariable("id")Long id){
        //这里使用openfeign接口方式远程调用
        log.info("调用方式是 openfeign..");
        return memberOpenFeignService.getMemberById(id);
    }

    //方法1/接口. 添加member
    @PostMapping("/member/nacos/consumer/save")
    public Result save(Member member) {
        //log.info("service-consumer member={}", member);
        return restTemplate.postForObject(MEMBER_SERVICE_NACOS_PROVIDER_URL
                + "/member/save", member, Result.class);
    }

    //方法3/接口. 查询member
    @GetMapping("/member/nacos/consumer/get/{id}")
    public Result<Member> getMemberById(@PathVariable("id") Long id) {

        return restTemplate.getForObject(
                MEMBER_SERVICE_NACOS_PROVIDER_URL + "/member/get/" + id, Result.class);
    }
}
