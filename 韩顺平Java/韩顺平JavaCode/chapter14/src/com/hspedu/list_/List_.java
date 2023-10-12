package com.hspedu.list_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class List_ {
    @SuppressWarnings({"all"})
    public static void main(String[] args) {
        //1.List 集合类中元素有序(即添加顺序和取出顺序一致)、且可重复
        List list = new ArrayList();
        list.add("jack");
        list.add("Tom");
        list.add("mary");
        list.add("hsp");
        list.add("Tom");
        System.out.println("list=" + list);
        //2.List集合中的每个元素都有其对应的顺序索引，即支持索引。
        //  索引是从0开始的
        System.out.println(list.get(3));//hsp
    }
}
