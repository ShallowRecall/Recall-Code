package com.hspedu.map_;

import java.util.HashMap;

/**
 * @author Zhou Yu
 * @version 1.0
 */
public class HashMapSource2 {
    public static void main(String[] args) {
        HashMap hashMap = new HashMap();
        for (int i = 1; i <= 12; i++) {
            hashMap.put(i, "hello");
        }

        hashMap.put("aaa","bbb");

        System.out.println("hashMap=" + hashMap);//12个 k-v
    }
}

class A {
    private int num;

    public A(int num) {
        this.num = num;
    }

    //所有的A对象的hashCode都是100
//    @Override
//    public int hashCode() {
//        return 100;
//    }

    @Override
    public String toString() {
        return "\nA{" +
                "num=" + num +
                '}';
    }
}
