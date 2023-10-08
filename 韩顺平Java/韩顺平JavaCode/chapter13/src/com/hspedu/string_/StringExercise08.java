package com.hspedu.string_;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class StringExercise08 {
    public static void main(String[] args) {
        String a = "hello";//创建a对象
        String b = "abc";//创建b对象
        //解读
        //1. 先 创建一个 StringBuilder sb = StringBuilder()
        //2. 执行  sb.append("hello");
        // 3. sb.append("abc");
        // 4.String c=sb.toString()
        //最后其实是 c 指向堆中的对象(String) value[] -> "helloabc"
        String c = a + b;
        String d = "helloabc";
        System.out.println(c == d);//false
        String e = "hello" + "abc";//直接看池，e指向常量池
        System.out.println(d == e);//True
    }
}
