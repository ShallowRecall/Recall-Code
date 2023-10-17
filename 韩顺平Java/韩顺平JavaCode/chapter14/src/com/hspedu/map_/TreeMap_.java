package com.hspedu.map_;

import java.util.Comparator;
import java.util.TreeMap;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SuppressWarnings({"all"})
public class TreeMap_ {
    public static void main(String[] args) {

        //使用默认的构造器，创建一个TreeMap,是无序的(也没有排序)
        /*
            老韩要求：要求按照传入的 k(String) 的大小进行排序
         */
//        TreeMap treeMap = new TreeMap();
        TreeMap treeMap = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                //按照传入的 k(String) 的大小进行排序
                //按照K(String) 的长度大小排序
//                return ((String) o2).compareTo((String) o1);
                return ((String) o2).length() - ((String) o1).length();
            }
        });
        treeMap.put("jack", "杰克");
        treeMap.put("tom", "汤姆");
        treeMap.put("kristina", "克瑞斯提诺");
        treeMap.put("smith", "斯密斯");
        treeMap.put("hsp", "韩顺平");//加入不了

        System.out.println("treemap=" + treeMap);

        /*
            源码解读：
            1.构造器，把传入的实现了 Comparator接口的匿名内部类(对象)，传给了TreeMap的comparator
                public TreeMap(Comparator<? super K> comparator) {
                    this.comparator = comparator;
                }
             2. 调用put方法
             2.1 第一次添加,把k-v 封装到 Entry对象，放入root
             Entry<K,V> t = root;
                if (t == null) {
                    compare(key, key); // type (and possibly null) check

                    root = new Entry<>(key, value, null);
                    size = 1;
                    modCount++;
                    return null;
                }
              2.2 以后添加
               Comparator<? super K> cpr = comparator;
                if (cpr != null) {
                    do { //遍历所有的key，给当前key找到适当位置
                        parent = t;
                        cmp = cpr.compare(key, t.key);//动态绑定到我们的匿名内部类的compare
                        if (cmp < 0)
                            t = t.left;
                        else if (cmp > 0)
                            t = t.right;
                        else //如果遍历过程中，发现准备添加key 和当前已有的key 是相等，就不添加
                            return t.setValue(value);
                    } while (t != null);
                }
         */
    }
}
