package com.hspedu.springboot;

import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

/**
 * @author ZhouYu
 * @version 1.0
 */
// 要求扫描com.hspedu.springboot 包/子包下的原生方式注入的Servlet
//@ServletComponentScan(basePackages = "com.hspedu.springboot")
@SpringBootApplication
public class Application {
    public static void main(String[] args) {

        ConfigurableApplicationContext ioc =
                SpringApplication.run(Application.class, args);

        //ioc.stop(); // 停止容器
        System.out.println("hello");
    }

}
