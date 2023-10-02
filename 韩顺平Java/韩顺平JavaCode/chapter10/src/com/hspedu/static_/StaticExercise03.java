package com.hspedu.static_;

public class StaticExercise03 {
    public static void main(String[] args) {
        Person.setTotalPerson(3);
        new Person();//最后total的值就是4
        Person.m();
    }
}

class Person {
    private int id;
    private static int total = 0;

    public static void setTotalPerson(int total) {
        //this.total = total;//错误，因为在static方法中，不能使用this关键字
        Person.total = total;
    }

    public Person() {//构造器
        total++;
        id = total;
    }

    //编写一个方法输total的值
    public static void m() {
        System.out.println("total的值" + total);
    }
}