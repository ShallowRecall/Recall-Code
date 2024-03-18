package com.hspedu.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author ZhouYu
 * @version 1.0
 */
// 要求扫描com.hspedu.springboot 包/子包下的原生方式注入的Servlet
@ServletComponentScan(basePackages = "com.hspedu.springboot")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

        System.out.println("hello");
    }
}
