package com.hspedu.homework;

public class Homework03 {
    public static void func(){//静态方法
        try{
            throw new RuntimeException();
        }finally {
            System.out.println("B");
        }
    }

    public static void main(String[] args) {
        try{
            func();
            System.out.println("A");
        }catch (Exception e){
            System.out.println("C");
        }
        System.out.println("D");
    }
}
