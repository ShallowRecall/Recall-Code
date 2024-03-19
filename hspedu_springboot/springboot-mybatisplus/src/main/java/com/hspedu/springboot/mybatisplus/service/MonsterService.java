package com.hspedu.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.hspedu.springboot.mybatisplus.bean.Monster;

/**
 * @author ZhouYu
 * @version 1.0
 * 解读
 * 1. 传统方式 在接口中 定义方法/声明方法，然后再实现类中进行实现
 * 2. 在Mybatis-Plus中，我们可以继承父接口 IService
 * 3. 这个IService接口中声明很多方法，比如crud
 * 4. 如果默认的提供的方法不能满足需求，我们可以再声明需要的方法，然后在实现类中进行实现即可
 */
public interface MonsterService extends IService<Monster> {
    // 自定义方法
    //public void t1();
}
