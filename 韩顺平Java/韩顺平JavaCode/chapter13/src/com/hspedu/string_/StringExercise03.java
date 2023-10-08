package com.hspedu.string_;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class StringExercise03 {
    public static void main(String[] args) {
        String a = "hsp";//a 指向 常量池的"hsp"
        String b = new String("hsp");//b 指向堆中对象 value
        System.out.println(a.equals(b));//T
        System.out.println(a == b);//F
        //b.intern() 返回常量池的地址
        System.out.println(a == b.intern());
        System.out.println(b == a.intern());
    }
}
