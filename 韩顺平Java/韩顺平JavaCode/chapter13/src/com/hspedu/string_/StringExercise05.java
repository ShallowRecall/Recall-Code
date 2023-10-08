package com.hspedu.string_;

/**
 * @author ZhouYu
 * @version 1.0
 */
class Person{
    String name;
}
public class StringExercise05 {
    public static void main(String[] args) {
        Person p1 = new Person();
        p1.name = "hspedu";
        Person p2 = new Person();
        p2.name = "hspedu";

        System.out.println(p1.name.equals(p2.name));//比较内容
        System.out.println(p1.name == p2.name);//T
        System.out.println(p1.name == "hspedu");

        String s1 = new String("bcde");
        String s2 = new String("bced");
        System.out.println(s1 == s2);//False
    }
}
