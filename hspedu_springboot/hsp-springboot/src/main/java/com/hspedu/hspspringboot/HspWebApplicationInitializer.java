package com.hspedu.hspspringboot;

import com.hspedu.hspspringboot.config.HspConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * @author ZhouYu
 * @version 1.0
 * Initializer：初始化器
 */

/**
 * 解读
 * 1. 创建我们的Spring 容器
 * 2. 加载/关联Spring容器的配置-按照注解的方式
 * 3. 完成Spring容器配置的bean的创建，依赖注入
 * 4. 创建前端控制器 DispatcherServlet，并让其持有Spring容器
 * 5. 当DispatcherServlet 持有容器，就可以进行分发映射
 * 6. 这里onStartup 是Tomcat调用，并把ServletContext 对象传入
 */
public class HspWebApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("startup ....");
        //加载Spring web application configuration => 容器
        AnnotationConfigWebApplicationContext ac =
                new AnnotationConfigWebApplicationContext();
        // 在ac中注册 HspConfig.class 配置类
        ac.register(HspConfig.class);
        ac.refresh();//完成bean的创建和配置

        //1. 创建注册非常重要的前端控制器 DispatcherServlet
        //2. 让DispatcherServlet 持有容器
        //3. 这样就可以进行映射分发
        DispatcherServlet dispatcherServlet =
                new DispatcherServlet();
        // 返回了ServletRegistration.Dynamic对象
        ServletRegistration.Dynamic registration =
                servletContext.addServlet("app", dispatcherServlet);
        // 当tomcat启动时，加载 dispatcherServlet
        registration.setLoadOnStartup(1);
        // 拦截请求，并进行分发处理
        // / 和 /* 的区别
        registration.addMapping("/");
    }
}
