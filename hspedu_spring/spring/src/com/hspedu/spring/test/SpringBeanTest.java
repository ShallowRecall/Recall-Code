package com.hspedu.spring.test;

import com.hspedu.spring.bean.*;
import com.hspedu.spring.component.UserAction;
import com.hspedu.spring.component.UserDao;
import com.hspedu.spring.component.UserService;
import com.hspedu.spring.depinjection.PhoneService;
import com.hspedu.spring.service.MemberServiceImpl;
import com.hspedu.spring.web.OrderAction;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class SpringBeanTest {

    //通泛型依赖配置Bean
    public void setProByDependencyInjection() {
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans07.xml");
        PhoneService phoneService = ioc.getBean("phoneService", PhoneService.class);
        phoneService.save();
        System.out.println("ok");
    }


    //通过注解来配置Bean
    @Test
    public void setProByAutoWired() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans06.xml");

        UserService userService = ioc.getBean("userService", UserService.class);
        System.out.println("ioc容器中的userService=" + userService);

        UserAction userAction = ioc.getBean("userAction", UserAction.class);
//        System.out.println("userAction" + userAction);
        userAction.sayOk();

    }


    //通过注解来配置Bean
    @Test
    public void setBeanByAnnotation() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans05.xml");

        UserDao userDao = ioc.getBean(UserDao.class);
        //在默认情况下，注解标识的类创建对象后，在容器中，id 为类名的首字母小写
        UserDao userDao1 = ioc.getBean("userDao", UserDao.class);
        System.out.println("userDao1=" + userDao1);
        UserService userService = ioc.getBean(UserService.class);
        UserAction userAction = ioc.getBean(UserAction.class);
//        MyComponent myComponent = ioc.getBean(MyComponent.class);

        System.out.println("userDao=" + userDao);
        System.out.println("userService=" + userService);
        System.out.println("userAction=" + userAction);
//        System.out.println("myComponent=" + myComponent);

        System.out.println("ok");


    }


    //通过spring el 对属性赋值
    @Test
    public void setBeanBySpel() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans04.xml");
        SpELBean spELBean = ioc.getBean("spELBean", SpELBean.class);
        System.out.println("spELBean=" + spELBean);
    }


    //通过自动装配来对属性赋值
    @Test
    public void setBeanByAutowire() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans03.xml");
        OrderAction orderAction = ioc.getBean("orderAction", OrderAction.class);


        //验证是否自动装配上OrderService
        System.out.println(orderAction.getOrderService());
        //验证是否自动装配上OrderDao
        System.out.println(orderAction.getOrderService().getOrderDao());
    }


    //通过属性文件给bean属性赋值
    @Test
    public void setBeanByFile() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans03.xml");

        Monster monster1000 = ioc.getBean("monster1000", Monster.class);
        System.out.println("monster100=" + monster1000);
    }


    @Test
    public void testBeanPostProcessor() {

        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans02.xml");

        House house = ioc.getBean("house", House.class);
        System.out.println("使用house=" + house);

        House house02 = ioc.getBean("house02", House.class);
        System.out.println("使用house02=" + house02);

        ((ConfigurableApplicationContext) ioc).close();
    }


    //测试Bean的生命周期
    @Test
    public void testBeanLife() {
//        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        ApplicationContext ioc =
                new ClassPathXmlApplicationContext("beans.xml");

        House house = ioc.getBean("house", House.class);

        System.out.println("使用house=" + house);

        //关闭容器
        //1. Java基础
        //2. ioc的编译类型 ApplicationContext ，运行类型 ClassPathXmlApplicationContext
        //3. 因为 ClassPathXmlApplicationContext 也实现了 ConfigurableApplicationContext
        //4. ConfigurableApplicationContext 是有close
        //5. 将ioc 转成ConfigurableApplicationContext，再调用close
        // 关闭容器
        ((ConfigurableApplicationContext) ioc).close();
    }


    //测试Scope
    @Test
    public void testBeanScope() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Cat cat = ioc.getBean("cat", Cat.class);
        Cat cat1 = ioc.getBean("cat", Cat.class);
        Cat cat2 = ioc.getBean("cat", Cat.class);
        System.out.println("cat=" + cat);
        System.out.println("cat1=" + cat1);
        System.out.println("cat2=" + cat2);
    }


    //测试Bean创建顺序
    @Test
    public void getBeanByCreate() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        System.out.println("ok");

    }


    //配置Bean通过继承
    @Test
    public void getBeanByExtends() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        Monster monster11 = ioc.getBean("monster11", Monster.class);
        System.out.println("monster11=" + monster11);

        Monster monster13 = ioc.getBean("monster13", Monster.class);
        System.out.println("monster13=" + monster13);

    }


    //通过FactoryBean获取bean
    @Test
    public void getBeanByFactoryBean() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster05 = ioc.getBean("my_monster05", Monster.class);
        System.out.println("my_monster05=" + my_monster05);
    }


    //通过实例工厂获取bean
    @Test
    public void getBeanByInstanceFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster02 = ioc.getBean("my_monster02", Monster.class);
        Monster my_monster03 = ioc.getBean("my_monster03", Monster.class);
        System.out.println("my_monster02=" + my_monster02);

        System.out.println(my_monster02 == my_monster03);
    }


    //通过静态工厂获取bean
    @Test
    public void getBeanByStaticFactory() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster my_monster01 = ioc.getBean("my_monster01", Monster.class);
        Monster my_monster04 = ioc.getBean("my_monster04", Monster.class);
        System.out.println("my_monster01=" + my_monster01);
        System.out.println("my_monster02=" + my_monster04);
        System.out.println(my_monster01 == my_monster04);//true
    }


    //对属性进行级联赋值
    @Test
    public void setBeanByRelation() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Emp emp = ioc.getBean("emp", Emp.class);
        System.out.println("emp=" + emp);
    }

    //给util:list 名称空间给属性赋值
    @Test
    public void setBeanByUtilList() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        BookStore bookStore = ioc.getBean("bookStore", BookStore.class);

        System.out.println("bookStore=" + bookStore);
    }

    //给集合数组属性进行赋值
    @Test
    public void setBeanByCollection() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        Master master = ioc.getBean("master", Master.class);
        System.out.println("master=" + master);
    }

    // 通过内部bean设置属性
    @Test
    public void setBeanByPro() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberService2 = ioc.getBean("memberService2", MemberServiceImpl.class);
        System.out.println("memberService2=" + memberService2);
    }


    // 通过ref来设置bean属性
    @Test
    public void setBeanByRef() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster06 = ioc.getBean("monster06", Monster.class);
        System.out.println("monster06=" + monster06);
    }

    // 通过p 名称空间来设置属性
    @Test
    public void setBeanByP() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        MemberServiceImpl memberService = ioc.getBean("memberService", MemberServiceImpl.class);
        memberService.add();

    }

    @Test
    //通过构造器来设置属性
    public void setBeanByConstructor() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        Monster monster03 = ioc.getBean("monster03", Monster.class);
        System.out.println("monster03=" + monster03);

    }

    @Test
    //通过Bean的类型来获取对象
    public void getBeanByType() {
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");
        // 直接传入一个class对象/类型
        Monster bean = ioc.getBean(Monster.class);
        System.out.println("bean=" + bean);


    }


    @Test
    public void getMonster() {
        //解读
        //1. 创建容器 ApplicationContext
        //2. 该容器和容器配置文件关联
        ApplicationContext ioc = new ClassPathXmlApplicationContext("beans.xml");

        //3. 通过getBean获取对应的对象
        //   默认返回的是Object ，但是运行类型Monster
        //Object monster01 = ioc.getBean("monster01");
        Monster monster01 = (Monster) ioc.getBean("monster01");

        //4. 输出
        //System.out.println("monster01" + monster01 + " 运行类型" + monster01.getClass());
        System.out.println("monster01=" + monster01 + " 属性name=" + monster01.getMonsterId() + " MonsterId=" + monster01.getMonsterId());


        //5. 也可以在获取的时候，直接指定Class类型，可以再次获取
        Monster monster011 = ioc.getBean("monster01", Monster.class);
        System.out.println("monster011=" + monster011);
        System.out.println("monster011.name=" + monster011.getName());

        System.out.println("OK~~~");
    }

    @Test
    // 验证类加载路径
    public void classPath() {


        File file = new File(this.getClass().getResource("/").getPath());
        // 看到类的加载路径
        System.out.println("file=" + file);
    }
}
