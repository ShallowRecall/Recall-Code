package com.hspedu.spring.homework;

import com.hspedu.spring.bean.Car;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class homework02 {
    @Test
    public void getCar() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Car car01 = ioc.getBean("car01", Car.class);
        System.out.println("car01=" + car01);
        System.out.println("car01.id=" + car01.getId());
        System.out.println("car01.name=" + car01.getName());
        System.out.println("car01.price=" + car01.getPrice());

    }
}
