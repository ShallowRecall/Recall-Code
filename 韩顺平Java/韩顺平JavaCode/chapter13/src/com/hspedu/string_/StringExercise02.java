package com.hspedu.string_;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class StringExercise02 {
    public static void main(String[] args) {
        String a = "abc";
        String b = new String("abc");
        System.out.println(a.equals(b));//T
        System.out.println(a == b);//F
    }
}
