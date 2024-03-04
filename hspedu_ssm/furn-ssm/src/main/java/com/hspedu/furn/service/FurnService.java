package com.hspedu.furn.service;

import com.hspedu.furn.bean.Furn;

import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface FurnService {
    // 添加
    public void save(Furn furn);
    // 查询所有的家具信息
    public List<Furn> findAll();
    // 修改家具信息
    public void update(Furn furn);
    // 删除家具
    public void del(Integer id);
}
