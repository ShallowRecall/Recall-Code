package com.hspedu.springcloud.config;

import com.alibaba.druid.pool.DruidDataSource;
import io.seata.rm.datasource.DataSourceProxy;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.transaction.SpringManagedTransactionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;

/**
 * @author ZhouYu
 * @version 1.0
 * 说明：
 * 1. 配置数据源的代理是seata 也就是使用seata代理数据源
 * 2. DataSourceProxy 是引入的 io.seata.rm.datasource.DataSourceProxy
 */
@Configuration
public class DataSourceProxyConfig {

    @Value("${mybatis.mapperLocations}")
    private String mapperLocations;

    //配置druidDatasource
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource() {
        /*DruidDataSource druidDataSource = new DruidDataSource();
        System.out.println("druidDataSource.hashcode=" + druidDataSource.hashCode());
        return druidDataSource;*/
        return new DruidDataSource();
    }

    //配置DataSourceProxy- 使用seata代理数据源
    @Bean
    public DataSourceProxy dataSourceProxy(DataSource dataSource) {
        /*System.out.println("dataSourceProxy() 中的 dataSource.hashcode=" + dataSource.hashCode());
        DataSourceProxy dataSourceProxy = new DataSourceProxy(dataSource);
        System.out.println("dataSourceProxy.hashcode=" + dataSourceProxy.hashCode());*/
        return new DataSourceProxy(dataSource);
    }

    //配置SqlSessionFactory-常规写法
    @Bean
    public SqlSessionFactory sqlSessionFactoryBean(DataSourceProxy dataSourceProxy)
            throws Exception {
        //System.out.println("sqlSessionFactoryBean() 中的 dataSourceProxy.hashcode=" + dataSourceProxy.hashCode());
        SqlSessionFactoryBean sqlSessionFactoryBean =
                new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSourceProxy);
        sqlSessionFactoryBean.setMapperLocations
                (new PathMatchingResourcePatternResolver().getResources(mapperLocations));
        sqlSessionFactoryBean.setTransactionFactory
                (new SpringManagedTransactionFactory());
        return sqlSessionFactoryBean.getObject();
    }
}
