package com.hspedu.furn.service;

import com.hspedu.furn.bean.Furn;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;
import java.util.List;

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
    public void save() {

        Furn furn = new Furn(null, "小风扇", "顺平家具~~", new BigDecimal(180), 666, 70, "assets/images/product-image/1.jpg");

        furnService.save(furn);

        System.out.println("添加成功~");
    }

    @Test
    public void findAll() {

        List<Furn> furns = furnService.findAll();
        for (Furn furn : furns) {
            System.out.println("furn-" + furn);
        }
    }

    @Test
    public void update(){

        Furn furn = new Furn();
        furn.setId(1);
        furn.setName("北欧风格小桌子~~");
        furn.setMaker("小猪家具");
        // 因为imgPath属性有一个默认值，
        // 所以如果我们不希望生成update 语句有对imgPath 字段修改，就显式的设置null

        furn.setImgPath(null);

        furnService.update(furn);

        System.out.println("修改OK");
    }

    @Test
    public void del(){

        furnService.del(11);
        System.out.println("删除OK");
    }

    @Test
    public void findByCondition(){

        List<Furn> furnList = furnService.findByCondition("风格");
        for (Furn furn : furnList) {
            System.out.println(furn);
        }
    }
}
