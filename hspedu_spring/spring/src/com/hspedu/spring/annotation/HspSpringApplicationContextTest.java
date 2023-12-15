package com.hspedu.spring.annotation;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class HspSpringApplicationContextTest {
    public static void main(String[] args) {

        HspSpringApplicationContext ioc =
                new HspSpringApplicationContext(HspSpringConfig.class);

        System.out.println("ok");
    }
}
