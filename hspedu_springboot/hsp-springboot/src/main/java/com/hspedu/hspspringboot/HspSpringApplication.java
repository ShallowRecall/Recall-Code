package com.hspedu.hspspringboot;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class HspSpringApplication {
    // 这里我们会创建tomcat对象，并关联Spring容器，并启动
    public static void run(){
        try {
            // 创建Tomcat对象
            Tomcat tomcat = new Tomcat();
            //1. 让tomcat可以将请求转发到spring web容器，因此需要进行关联
            //2. "/hspboot" 就是我们的项目的 application context ，就是我们原来配置tomcat时，指定的application context
            //3. "/Users/zhouyu/Recall-Code/hspedu_springboot/hsp-springboot" 指定项目的目录
            tomcat.addWebapp("/hspboot", "/Users/zhouyu/Recall-Code/hspedu_springboot/hsp-springboot");
            // 设置9090
            tomcat.setPort(9090);
            // 启动
            tomcat.start();
            // 等待请求的接入
            System.out.println("======9090====等待请求=====");
            tomcat.getServer().await();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
