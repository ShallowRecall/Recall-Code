package com.hspedu.furn.service;

import com.hspedu.furn.bean.Furn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FurnServiceTest {

    //属性
    private ApplicationContext ioc;
    //从spring容器中，获取的是FurnService接口对象/ 代理对象
    private FurnService furnService;

    @Before
    public void init() {
        ioc = new ClassPathXmlApplicationContext("applicationContext.xml");
        //1. 通过FurnService.class 类型获取FurnService接口对象/ 代理对象
        furnService = (FurnService) ioc.getBean(FurnService.class);
        System.out.println("furnService-" + furnService.getClass());
    }

    @Test
    public void save(){

        Furn furn = new Furn(null, "小风扇", "顺平家具~~", new BigDecimal(180), 666, 70, "assets/images/product-image/1.jpg");

        furnService.save(furn);

        System.out.println("添加成功~");
    }
}
