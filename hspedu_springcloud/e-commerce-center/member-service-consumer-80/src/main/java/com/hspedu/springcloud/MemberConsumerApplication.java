package com.hspedu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author ZhouYu
 * @version 1.0
 */
//@EnableEurekaClient 将程序标识为eureka client
@EnableEurekaClient
@SpringBootApplication
public class MemberConsumerApplication {
    public static void main(String[] args) {

        SpringApplication.run(MemberConsumerApplication.class, args);
    }
}
