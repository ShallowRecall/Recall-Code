package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author ZhouYu
 * @version 1.0
 */
@FeignClient(value = "member-service-nacos-provider",fallback = MemberFeignFallbackService.class)
public interface MemberOpenFeignService {
    /**
     * 解读：
     * 1. 远程调用方式是 get
     * 2. 远程调用的url 为 http://member-service-nacos-provider
     * 3. member-service-nacos-provider 是nacos注册中心服务名
     * 4. openfeign会根据负载均衡算法来决定调用的是 10004/10006, 默认是轮询算法
     * 5. openfeign是通过接口方式调用服务
     */
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id);
}
