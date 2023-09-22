package com.hspedu.override_;

public class Dog extends Animal{
    //1.因为Dog 是 Animal子类
    //2.Dog的 cry方法和 Animal的 cry定义形式一样(名称、返回类型、参数)
    //3.这时我们就说 Dog的cry方法，重写了Animal的cry方法
    public void cry(){
        System.out.println("小狗汪汪叫..");
    }
}
