package com.hspedu.spring.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
// 也可以使用@Service
@Component
public class UserService {

    // 定义属性
    //也可以使用@Resource
    @Autowired
    private UserDao userDao;

    public void m1(){
        userDao.hi();
    }
}
