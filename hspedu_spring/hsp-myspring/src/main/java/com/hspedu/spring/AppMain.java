package com.hspedu.spring;

import com.hspedu.spring.component.MonsterDao;
import com.hspedu.spring.component.MonsterService;
import com.hspedu.spring.ioc.HspSpringApplicationContext;
import com.hspedu.spring.ioc.HspSpringConfig;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class AppMain {
    public static void main(String[] args) {
        //创建自己的容器
        HspSpringApplicationContext hspSpringApplicationContext =
                new HspSpringApplicationContext(HspSpringConfig.class);

        //测试一下依赖注入的功能
        MonsterService monsterService =
                (MonsterService) hspSpringApplicationContext.getBean("monsterService");

        monsterService.m1();




        /*MonsterService monsterService =
                (MonsterService) hspSpringApplicationContext.getBean("monsterService");
        MonsterService monsterService2 =
                (MonsterService) hspSpringApplicationContext.getBean("monsterService");

        System.out.println("monsterService=" + monsterService);
        System.out.println("monsterService2=" + monsterService2);

        MonsterDao monsterDao =
                (MonsterDao) hspSpringApplicationContext.getBean("monsterDao");
        MonsterDao monsterDao2 =
                (MonsterDao) hspSpringApplicationContext.getBean("monsterDao");

        System.out.println("monsterDao=" + monsterDao);
        System.out.println("monsterDao2=" + monsterDao2);*/


        System.out.println("ok");
    }
}
