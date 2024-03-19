package com.hspedu.springboot.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Arrays;

/**
 * @author ZhouYu
 * @version 1.0
 * DruidDataSourceConfig：配置类
 */
@Configuration
public class DruidDataSourceConfig {

    // 编写方法，注入DruidDataSource
    // 还要说明一下为什么我们注入自己的DataSource，默认的HiKariDatasource失效?
    // 1. 默认的数据源是如何配置的？@ConditionalOnMissingBean({ DataSource.class, XADataSource.class})
    //    通过@ConditionalOnMissingBean({ DataSource.class }) 判断如果容器有DataSource Bean 就不注入默认的HiKariDatasource
    // 2. debug源码

    @ConfigurationProperties("spring.datasource")
    @Bean
    public DataSource dataSource() throws SQLException {
        //1. 配置了  @ConfigurationProperties("spring.datasource")
        //   就可以读取到application.yml的配置
        //2. 我们就不需要调用DruidDataSource 对象的setXxx，会自动关联

        DruidDataSource druidDataSource = new DruidDataSource();
        /*druidDataSource.setUrl();
        druidDataSource.setUsername();
        druidDataSource.setPassword();*/
        // 加入监控功能，加入了sql防火墙监控
        druidDataSource.setFilters("stat,wall");
        return druidDataSource;
    }

    // 配置druid的监控页功能
    @Bean
    public ServletRegistrationBean statViewServlet() {

        //创建StatViewServlet
        StatViewServlet statViewServlet = new StatViewServlet();
        ServletRegistrationBean<StatViewServlet> registrationBean =
                new ServletRegistrationBean<>(statViewServlet, "/druid/*");

        // 设置init-parameter，设置用户名和密码
        registrationBean.addInitParameter("loginUsername", "Recall");
        registrationBean.addInitParameter("loginPassword", "123456");

        return registrationBean;
    }

    //配置WebStatFilter，用于采集web-jdbc 关联的监控数据

    @Bean
    public FilterRegistrationBean webStatFilter() {
        // 创建 WebStatFilter
        WebStatFilter webStatFilter = new WebStatFilter();

        FilterRegistrationBean<WebStatFilter> filterRegistrationBean =
                new FilterRegistrationBean<>(webStatFilter);

        //默认对所有的url请求进行监控
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/*"));

        //排除指定的url
        filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
