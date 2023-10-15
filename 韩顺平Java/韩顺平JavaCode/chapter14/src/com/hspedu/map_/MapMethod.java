package com.hspedu.map_;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class MapMethod {
    public static void main(String[] args) {
        //演示map接口常用方法

        Map map = new HashMap();
        map.put("邓超", new Book("", 100));//ok
        map.put("邓超", "孙俪");//替换
        map.put("王宝强", "马蓉");//ok
        map.put("宋喆", "马蓉");//ok
        map.put("刘令博", null);//ok
        map.put(null, "刘亦菲");//ok
        map.put("鹿晗", "关晓彤");//ok

        System.out.println("map=" + map);

        //
    }
}

class Book {
    private String name;
    private int num;

    public Book(String name, int num) {
        this.name = name;
        this.num = num;
    }
}