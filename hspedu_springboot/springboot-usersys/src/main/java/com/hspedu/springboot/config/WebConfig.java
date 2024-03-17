package com.hspedu.springboot.config;

import com.hspedu.springboot.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ {

  /*  @Override
    public void addInterceptors(InterceptorRegistry registry) {

        //注册自定义拦截器LoginInterceptor
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/**") //拦截所有的请求
                .excludePathPatterns("/","/login","/images/**");//指定要放行的，后面可以根据业务需要添加放行的路径
    }*/

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){

        return new WebMvcConfigurer() {
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
                System.out.println("addInterceptors~~~");
                //注册拦截器
                registry.addInterceptor(new LoginInterceptor())
                        .addPathPatterns("/**")
                        .excludePathPatterns("/","/login","/images/**","/upload.html","/upload");
            }
        };
    }
}
