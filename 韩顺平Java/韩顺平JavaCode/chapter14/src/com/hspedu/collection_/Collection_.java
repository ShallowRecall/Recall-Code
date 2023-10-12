package com.hspedu.collection_;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Collection_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //解读
        //1. 集合主要是两组(单列集合 ，双列集合)
        //2. Collection 接口有两个重要的子接口 List Set，他们的实现子类都是单列集合
        //3. Map 接口的实现子类 是双列集合，存放的 K-V
        //4. 把两张图记住
        //Collection
        //Map
        ArrayList arrayList = new ArrayList();
        arrayList.add("jack");
        arrayList.add("tom");

        HashMap hashMap = new HashMap();
        hashMap.put("NO1","北京");
        hashMap.put("No2","上海");
    }
}
