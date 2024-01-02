package com.hspedu.spring.component;

import com.hspedu.spring.annotation.Autowired;
import com.hspedu.spring.annotation.Component;
import com.hspedu.spring.processor.InitializingBean;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component

public class Car implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Car的初始化方法..");
    }
}
