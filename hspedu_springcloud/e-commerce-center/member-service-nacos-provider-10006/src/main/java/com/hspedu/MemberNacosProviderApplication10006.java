package com.hspedu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZhouYu
 * @version 1.0
 */
//@EnableDiscoveryClient 引入的是Nacos发现注解
@EnableDiscoveryClient
@SpringBootApplication
public class MemberNacosProviderApplication10006 {
    public static void main(String[] args) {
        SpringApplication.run(MemberNacosProviderApplication10006.class, args);
    }
}
