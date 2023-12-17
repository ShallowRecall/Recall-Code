package com.hspedu.spring.depinjection;

/**
 * @author ZhouYu
 * @version 1.0
 *
 * 自定义的泛型类
 */
public abstract class BaseDao<T> {
    public abstract void save();
}
