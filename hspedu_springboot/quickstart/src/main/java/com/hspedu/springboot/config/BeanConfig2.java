package com.hspedu.springboot.config;

import com.hspedu.springboot.bean.Monster;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouYu
 * @version 1.0
 *
 * 这是第二个配置类
 */
@Configuration
public class BeanConfig2 {

    @Bean
    public Monster monster02(){
        return new Monster(800,"蚂蚁精",80,"吃小昆虫");
    }
}
