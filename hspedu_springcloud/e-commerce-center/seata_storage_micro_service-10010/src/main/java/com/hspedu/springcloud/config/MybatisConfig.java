package com.hspedu.springcloud.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author ZhouYu
 * @version 1.0
 * 常规配置 Mybatis 和 dao关联
 */
@Configuration
@MapperScan({"com.hspedu.springcloud.dao"})
public class MybatisConfig {
}
