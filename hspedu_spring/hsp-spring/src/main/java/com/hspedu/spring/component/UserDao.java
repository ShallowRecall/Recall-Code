package com.hspedu.spring.component;

import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
// 可以使用@Repository
@Component
public class UserDao {

    public void hi(){
        System.out.println("UserDao-hi()---");
    }
}
