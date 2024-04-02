package com.hspedu.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ZhouYu
 * @version 1.0
 * 解读
 * 1. 使用MapperScan 可以指定要扫描的Mapper接口
 * 2. 属性basePackages 可以指定多个包
 */
@MapperScan(basePackages = {"com.hspedu.springboot.mybatisplus.mapper"})
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
