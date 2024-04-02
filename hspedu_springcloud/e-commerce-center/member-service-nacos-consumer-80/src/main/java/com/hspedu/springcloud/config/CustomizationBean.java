package com.hspedu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author ZhouYu
 * @version 1.0
 * CustomizationBean：配置类
 * 配置注入RestTemplate bean/对象
 */
@Configuration
public class CustomizationBean {

    // 配置注入RestTemplate bean/对象
    //@LoadBalanced 赋予 RestTemplate 负载均衡的能力，也就是会根据你的负载均衡算法
    // 来选择某个服务去访问，默认是轮询算法来访问远程调用接口/地址
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
