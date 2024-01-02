package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.processor.InitializingBean;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component(value = "monsterDao")
public class MonsterDao implements InitializingBean {

    public void hi() {
        System.out.println("MonsterDao-hi()");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MonsterDao 初始化方法被调用..");
    }
}
