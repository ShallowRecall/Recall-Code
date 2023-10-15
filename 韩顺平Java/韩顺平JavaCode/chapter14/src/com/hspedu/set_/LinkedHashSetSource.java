package com.hspedu.set_;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @author ZhouYu
 * @version 1.0
 */

@SuppressWarnings({"all"})
public class LinkedHashSetSource {
    public static void main(String[] args) {
        //分析一下LinkedHashSet的底层机制

        Set set = new LinkedHashSet();
        set.add(new String("AA"));
        set.add(456);
        set.add(456);
        set.add(new Customer("刘", 1001));
        set.add(123);
        set.add("HSP");
        System.out.println("set=" + set);
        //解读：
        //1. LinkedHashSet 加入顺序和取出元素/数据的顺序一致
        //2. LinkedHashSet 底层维护的是一个LinkedHashMap(是HashMap死亡子类)
        //3. LinkedHashSet 底层结构  (数组 + 双向链表)
        //4. 添加第一次时，直接将 数组table 扩容到 16 ，存放的结点类型是 LinkedHashMap$Entry
        //5. 数组是 HashMap$Node[] 存放的元素/数据是 LinkedHashMap$Entry类型
        /*
                    //继承关系是在内部类完成.
                    static class Entry<K,V> extends HashMap.Node<K,V> {
                        Entry<K,V> before, after;
                        Entry(int hash, K key, V value, Node<K,V> next) {
                            super(hash, key, value, next);
                        }
                    }
         */
    }
}

class Customer {
    private String name;
    private int id;

    public Customer(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}