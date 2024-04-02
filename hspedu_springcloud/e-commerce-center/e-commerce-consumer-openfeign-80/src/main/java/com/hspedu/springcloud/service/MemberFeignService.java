package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import lombok.extern.java.Log;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component
@FeignClient(value = "MEMBER-SERVICE-PROVIDER")
public interface MemberFeignService {

    //这里定义方法-就是远程调用的接口

    /**
     * 1. 远程调用的方式是get
     * 2. 远程调用的url http://MEMBER-SERVICE-PROVIDER/member/get/{id}
     * 3. MEMBER-SERVICE-PROVIDER 就是服务提供方在Eureka Server 注册的服务
     * 4. openfeign 会根据负载均衡来决定调用10000/10002-默认是轮询
     * 5. 因为openfeign 好处是支持了springmvc注解 + 接口解耦
     */
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id);
}
