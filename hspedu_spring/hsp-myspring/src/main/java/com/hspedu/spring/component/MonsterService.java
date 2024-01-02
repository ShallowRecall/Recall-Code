package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Autowired;
import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.annotation.Scope;
import com.hspedu.spring.processor.InitializingBean;

/**
 * @author ZhouYu
 * @version 1.0
 * 说明MonsterService 是一个Service
 * 1. 如果指定了value，那么在注入spring容器时，以你指定的为准
 * 2. 如果没有指定value，则使用类名首字母小写名字
 */
@Component(value = "monsterService") //把MonsterService注入我们自己的spring容器中
@Scope(value = "prototype")
public class MonsterService implements InitializingBean {
    //这里我们使用自己的@Auowired 来修饰属性
    //表示该属性，是通过容器完成依赖注入
    //说明：我们实现按照名字组装即可
    @Autowired
    private MonsterDao monsterDao;

    public void m1(){
        monsterDao.hi();
    }

    /**
     * 解读：
     * 1. afterPropertiesSet就是在bean的setter方法执行完毕后被spring容器调用
     * 2. 即就是初始化方法
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterService 初始化方法被调用 程序员在这里加入初始化的业务..");
    }
}
