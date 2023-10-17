package com.hspedu.map_;

import java.util.Hashtable;

/**
 * @author Zhou Yu
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class HashTableExercise {
    public static void main(String[] args) {
        Hashtable table = new Hashtable();//ok
        table.put("john",100);//ok
//        table.put(null,100);//异常    NullPointerException
//        table.put("john",null);//异常 NullPointerException
        table.put("lucy",100);//ok
        table.put("lic",100);//ok
        table.put("lic",88);//替换
        System.out.println(table);

        //简单说明一下Hashtable的底层
        //1. 底层有一个数组 Hashtable$Entry[] 初始化大小为 11
        //2. 临界值 threshold 8 = 11 * 0.75
    }
}
