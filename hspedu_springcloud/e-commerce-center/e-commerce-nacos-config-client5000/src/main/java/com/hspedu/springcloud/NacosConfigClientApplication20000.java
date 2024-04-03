package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
public class NacosConfigClientApplication20000 {
    public static void main(String[] args) {
        SpringApplication.run(NacosConfigClientApplication20000.class, args);
    }
}
