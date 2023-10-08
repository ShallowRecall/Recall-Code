package com.hspedu.string_;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class StringExercise04 {
    public static void main(String[] args) {
        String s1 = "hspedu";
        String s2 = "java";
        String s4 = "java";
        String s3 = new String("java");
        System.out.println(s2 == s3);//F
        System.out.println(s2 == s4);//T
        System.out.println(s2.equals(s3));//T
        System.out.println(s1 == s2);//F
    }
}
