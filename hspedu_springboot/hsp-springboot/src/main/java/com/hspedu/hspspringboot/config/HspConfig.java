package com.hspedu.hspspringboot.config;

import com.hspedu.hspspringboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouYu
 * @version 1.0
 * HspConfig:配置类-作为Spring的配置文件
 * 这里有一个问题，容器怎么知道要扫描哪些包？
 *
 *
 * 在配置类可以指定要扫描包：@ComponentScan("com.hspedu.hspspringboot")
 */
@Configuration
@ComponentScan("com.hspedu.hspspringboot")
public class HspConfig {

    //注入Bean - monster 对象到Spring容器.
    @Bean
    public Monster monster(){
        return new Monster();
    }
}
