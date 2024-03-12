package com.hspedu.springboot;

import com.hspedu.springboot.bean.*;
import com.hspedu.springboot.config.BeanConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhouYu
 * @version 1.0
 * @SpringBootApplication：表示这是一个springboot应用/项目
 * @SpringBootApplication(scanBasePackages = "com.hspedu")
 * 解读：scanBasePackages = "com.hspedu" 指定springboot要扫描的包和子包
 * 如果有多个包，可以这样指定 scanBasePackages = {"com.hspedu","xx","yy","zz"}
 */
@SpringBootApplication(scanBasePackages = "com.hspedu")
public class MainApp {

    public static void main(String[] args) {

        // 启动springboot应用程序/项目
        ConfigurableApplicationContext ioc =
                SpringApplication.run(MainApp.class, args);


        // 如何查看容器中注入的组件
        /*String[] beanDefinitionNames = ioc.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println("beanDefinitionName--" + beanDefinitionName);
        }*/

        //====


        // 演示Spring中传统的注解依然可以使用 @Controller @Service @Repository @Component

        //A aBean = ioc.getBean(A.class);
        //System.out.println("aBean--" + aBean);

        // 演示在springboot 项目,依然可以使用spring的配置/bean/注入bean/获取bean start====

        /*ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");

        Monster monster03 = ac.getBean("monster03", Monster.class);
        System.out.println("monster03--" + monster03);*/

        // 演示在springboot 项目,依然可以使用spring的配置/bean/注入bean/获取bean end====

        // ===演示 @Configuration start ====

/*        Monster monster01 = ioc.getBean("monster01", Monster.class);
        Monster monster02 = ioc.getBean("monster01", Monster.class);

        System.out.println("monster01"+monster01+" "+monster01.hashCode());
        System.out.println("monster02"+monster02+" "+monster02.hashCode());*/

        // ===演示 @Configuration end ====

        // ===演示 配置类-bean也会注入到容器 start ====

        /*BeanConfig bean = ioc.getBean(BeanConfig.class);
        System.out.println("bean--" + bean);*/

        // ===演示 配置类-bean也会注入到容器 end ====


        // == 演示@Configuration(proxyBeanMethods = xxx) start

        //1. 先得到BeanConfig组件
       /* BeanConfig beanConfig = ioc.getBean(BeanConfig.class);
        Monster monster_01 = beanConfig.monster01();
        Monster monster_02 = beanConfig.monster01();
        System.out.println("monster_01"+monster_01+" "+monster_01.hashCode());
        System.out.println("monster_02"+monster_02+" "+monster_02.hashCode());
*/
        //特别说明 : proxyBeanMethods 是在 调用 @Bean 方法 才生效， 因此， 需要先获取 BeanConfig 组件，再调用方法
        //1. 而不是直接通过 SpringBoot 主程序得到的容器来获 取 bean, 注意观察直接通 过 ioc.getBean() 获取 Bean, proxyBeanMethods 值并没有生效

        /*Monster monster01 = ioc.getBean("monster01", Monster.class);
        Monster monster02 = ioc.getBean("monster01", Monster.class);
        System.out.println("monster01"+monster01+" "+monster01.hashCode());
        System.out.println("monster02"+monster02+" "+monster02.hashCode());*/

        // == 演示@Configuration(proxyBeanMethods = xxx) end

        // === 测试可以有多个配置类 start

        /*Monster monster02 = ioc.getBean("monster02", Monster.class);
        Monster monster01 = ioc.getBean("monster01", Monster.class);
        System.out.println("monster02--" + monster02);
        System.out.println("monster01--" + monster01);*/

        // === 测试可以有多个配置类 end


        // === 测试@Import 使用 start

        /*Dog dogBean = ioc.getBean(Dog.class);
        Cat catBean = ioc.getBean(Cat.class);
        System.out.println("dogBean--" + dogBean);
        System.out.println("catBean--" + catBean);*/

        // === 测试@Import 使用 end

        // 演示 @ConditionalOnBean 使用 start ===

        /*Dog dog01 = ioc.getBean("dog01", Dog.class);
        System.out.println("dog01--" + dog01);*/


        // 演示 @ConditionalOnBean 使用 end ===

        //演示@ImportResource 使用 start ===

        Monster monster04 = ioc.getBean("monster04", Monster.class);
        System.out.println("monster04-" + monster04);

        System.out.println("monster04 bean 是否存在-" + ioc.containsBean("monster04"));
        //演示@ImportResource 使用 end ===



    }

}
