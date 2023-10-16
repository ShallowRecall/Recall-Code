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
        map.put("hsp", "hsp的老婆");

        System.out.println("map=" + map);

        //remove:根据键删除映射关系
        map.remove(null);
        System.out.println("map=" + map);
        //get:根据键获取值
        Object val = map.get("鹿晗");
        System.out.println("val=" + val);
        //size:获取
        System.out.println("k-v=" + map.size());
        //isEmpty:判断个数是否为0
        System.out.println(map.isEmpty());//false
        //clear:清除k-v
        //map.clear();
        System.out.println("map=" + map);
        //containsKey:查找键是否存在
        System.out.println(map.containsKey("hsp"));//F
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