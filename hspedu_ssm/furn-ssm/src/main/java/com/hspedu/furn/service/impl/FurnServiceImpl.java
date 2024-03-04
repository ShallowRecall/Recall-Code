package com.hspedu.furn.service.impl;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.dao.FurnMapper;
import com.hspedu.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Service
public class FurnServiceImpl implements FurnService {


    //注入FurnMapper接口对象(代理对象)
    @Resource
    private FurnMapper furnMapper;

    @Override
    public void save(Furn furn) {
        //1. 使用insertSelective
        //2. 因为我们的furn的id是自增的，就使用insertSelective
        furnMapper.insertSelective(furn);
    }
}
