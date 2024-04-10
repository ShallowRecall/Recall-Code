package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author ZhouYu
 * @version 1.0
 */
@EnableDiscoveryClient //引入的是启动 nacos 发现注解
@SpringBootApplication
@EnableFeignClients
public class MemberNacosConsumerApplication80 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosConsumerApplication80.class, args);
    }
}
