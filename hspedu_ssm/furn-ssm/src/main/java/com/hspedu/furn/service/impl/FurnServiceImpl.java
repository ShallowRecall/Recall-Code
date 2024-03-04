package com.hspedu.furn.service.impl;

import com.hspedu.furn.bean.Furn;
import com.hspedu.furn.dao.FurnMapper;
import com.hspedu.furn.service.FurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Override
    public List<Furn> findAll() {
        // 查看分析FurnMapper.xml 文件
        // 传入是null，表示返回所有的家居信息
        return furnMapper.selectByExample(null);
    }

    @Override
    public void update(Furn furn) {
        furnMapper.updateByPrimaryKeySelective(furn);
    }

    @Override
    public void del(Integer id) {
        furnMapper.deleteByPrimaryKey(id);
    }
}
