//package com.hspedu.static_;
//
//public class StaticExercise02 {
//    public static void main(String[] args) {
//        System.out.println(Person.getTotalPerson());
//        Person person = new Person();
//        System.out.println(Person.getTotalPerson());
//    }
//}
//
//class Person{
//    private int id;
//    private static int total = 0;
//    public static int getTotalPerson(){
//        //id++;//错误
//        return total;
//    }
//    public Person(){//构造器
//        total++;//t0tal = 1
//        id = total;//id = 1
//    }
//}