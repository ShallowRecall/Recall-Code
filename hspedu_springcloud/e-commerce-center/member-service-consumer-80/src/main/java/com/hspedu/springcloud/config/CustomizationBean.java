package com.hspedu.springcloud.config;

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
    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
