package com.hspedu.homework;

import java.util.*;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class DAO<T> {
    private Map<String, T> map = new HashMap<>();

    public T get(String id) {
        return map.get(id);
    }

    public void update(String id, T entity) {
        map.put(id, entity);
    }

    //返回 map 中存放的所有 T 对象
    //遍历map [k-v]，将map的 所有value(T entity),封装到ArrayList返回即可
    public List<T> list() {
        //创建 ArrayList
        List<T> list = new ArrayList<>();

        //遍历map
        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            //map.get(key) 返回就是 User对象
            list.add(get(key));//也可以直接使用本类的 get(key)
        }
        return list;
    }

    public void delete(String id){
        map.remove(id);
    }

    public void save(String id,T entity){//把entity保存到map
        map.put(id, entity);
    }

}
