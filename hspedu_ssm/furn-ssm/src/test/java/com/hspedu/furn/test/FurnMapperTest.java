package com.hspedu.furn.test;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.dao.FurnMapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigDecimal;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FurnMapperTest {

    FurnMapper furnMapper;

    @Before
    public void before() {
        //1. 获取容器
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 获取FurnMapper
        furnMapper = app.getBean(FurnMapper.class);
    }

    @Test
    public void insertSelective() {
        //1. 获取容器
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 获取FurnMapper
        FurnMapper furnMapper = app.getBean(FurnMapper.class);
        //3. 添加数据
        Furn furn = new Furn(null, "北欧风格沙发~", "顺平家具~~", new BigDecimal(180), 666, 70, "assets/images/product-image/1.jpg");
        int affected = furnMapper.insertSelective(furn);
        System.out.println("affected--" + affected);
        System.out.println("操作成功");
    }

    @Test
    public void deleteByPrimaryKey() {
        //1. 获取容器
        ApplicationContext app =
                new ClassPathXmlApplicationContext("applicationContext.xml");
        //2. 获取FurnMapper
        FurnMapper furnMapper = app.getBean(FurnMapper.class);

        int affected = furnMapper.deleteByPrimaryKey(6);
        System.out.println("affected--" + affected);
        System.out.println("操作成功");

    }

    @Test
    public void updateByPrimaryKey() {
        Furn furn = new Furn();
        furn.setId(5);
        furn.setName("顺平风格的家居-小沙发");

        //会修改所有的字段，如果没有设置字段对应的属性值，那么默认是null
        //int affected = furnMapper.updateByPrimaryKey(furn);

        //根据设置属性对应字段，生成sql语句
        int affected = furnMapper.updateByPrimaryKeySelective(furn);
        System.out.println("affected--" + affected);
        System.out.println("操作成功");
    }

    @Test
    public void selectByPrimaryKey() {
        Furn furn = furnMapper.selectByPrimaryKey(1);
        System.out.println("furn--" + furn);
        System.out.println("操作成功~");
    }

}
