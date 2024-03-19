package com.hspedu.springboot.mybatis.service.impl;

import com.hspedu.springboot.mybatis.bean.Monster;
import com.hspedu.springboot.mybatis.mapper.MonsterMapper;
import com.hspedu.springboot.mybatis.service.MonsterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Service
public class MonsterServiceImpl implements MonsterService {

    //装配MonsterMapper
    @Resource
    private MonsterMapper monsterMapper;

    @Override
    public Monster getMonsterById(Integer id) {
        return monsterMapper.getMonsterById(id);
    }
}
