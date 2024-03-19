package com.hspedu.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hspedu.springboot.mybatisplus.bean.Monster;
import com.hspedu.springboot.mybatisplus.mapper.MonsterMapper;
import com.hspedu.springboot.mybatisplus.service.MonsterService;
import org.springframework.stereotype.Service;

/**
 * @author ZhouYu
 * @version 1.0
 * 解读
 * 1. 传统方式：在实现类中直接进行implements MonsterService
 * 2. 在mybatis-plus中，我们开发Service实现类，需要继承 ServiceImpl
 * 3. 我们观察看到 ServiceImpl类实现 IService
 * 4. MonsterService 接口他继承了 IService接口
 * 5. 这里MonsterServiceImpl 就可以认为实现了 MonsterService 接口，这样MonsterServiceImpl
 * 就可以使用IService接口方法，也可以理解成可以使用 MonsterService 方法
 * 6. 如果MonsterService接口中，声明了其它的方法/自定义方法，那么我们依然需要在MonsterServiceImpl中
 * 进行实现
 */
@Service
public class MonsterServiceImpl
        extends ServiceImpl<MonsterMapper, Monster>
        implements MonsterService {
    /*@Override
    public void t1() {

    }*/
}
