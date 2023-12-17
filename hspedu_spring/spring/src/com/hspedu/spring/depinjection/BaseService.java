package com.hspedu.spring.depinjection;



import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 *
 * 自定义泛型类
 */

public class BaseService<T> {

    @Resource
    public BaseDao<T> baseDao;

    public void save() {
        baseDao.save();
    }
}
