package com.hspedu.furn.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Configuration
@Slf4j
public class DruidDataSourceConfig {

    //配置/注入DruidDataSource
    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() {
        DruidDataSource druidDataSource = new DruidDataSource();
        log.info("数据源={}", druidDataSource.getClass());
        return druidDataSource;
    }
}
