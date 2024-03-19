package com.hspedu.springboot.config;

import com.hspedu.springboot.servlet.Filter_;
import com.hspedu.springboot.servlet.Listener_;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.hspedu.springboot.servlet.Servlet_;

import javax.servlet.ServletRegistration;
import java.util.Arrays;

/**
 * @author ZhouYu
 * @version 1.0
 * RegisterConfig_：是一个配置类
 * proxyBeanMethods = true : 默认是单例返回bean[保证每个@Bean 方法被调用多少次返回的组件都是单实例的，是代理方式]
 */
@Configuration(proxyBeanMethods = true)
public class RegisterConfig_ {

    // 使用RegistrationBean方式注入
    // 注入Servlet

    @Bean
    public ServletRegistrationBean servlet_(){
        // 创建原生的Servlet对象
        Servlet_ servlet_ = new Servlet_();
        // 把servlet_ 对象关联到 ServletRegistrationBean 对象
        // "/servlet01","/servlet02" 就是注入的Servlet的url-pattern
        return new ServletRegistrationBean(servlet_,"/servlet01","/servlet02");
    }

    // 注入filter

    @Bean
    public FilterRegistrationBean filter_(){
        Filter_ filter_ = new Filter_();// 创建原生的filter
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(filter_);
        //设置filter的url-pattern
        filterRegistrationBean.setUrlPatterns(Arrays.asList("/css/*","/images/*"));
        return filterRegistrationBean;
    }

    // 注入listener
    @Bean
    public ServletListenerRegistrationBean listener_(){

        // 创建原生的Listener对象
        Listener_ listener_ = new Listener_();

        return new ServletListenerRegistrationBean(listener_);
    }

}
