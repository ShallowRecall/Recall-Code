package com.hspedu.spring;

import com.hspedu.spring.ioc.HspSpringApplicationContext;
import com.hspedu.spring.ioc.HspSpringConfig;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class AppMain {
    public static void main(String[] args) {
        HspSpringApplicationContext hspSpringApplicationContext =
                new HspSpringApplicationContext(HspSpringConfig.class);
    }
}
