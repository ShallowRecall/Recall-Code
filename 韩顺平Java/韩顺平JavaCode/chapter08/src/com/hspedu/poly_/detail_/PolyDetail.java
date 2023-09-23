package com.hspedu.poly_.detail_;

public class PolyDetail {
    public static void main(String[] args) {


        //向上转型：父类的引用指向了子类的对象
        //语法：父类类型引用名 = new 子类类型();
        Animal animal = new Cat();
        Object obj = new Cat();//可以吗？可以 Object 也是 Cat的父类

        //向上转型调用方法的规则如下：
        //(1)可以调用父类中的所有成员(需遵守访问权限)
        //(2)但是不能调用子类特有的成员
        //(3)因为在编译阶段，能调用哪些成员，是有编译类型来决定的
        //animal.catchMouse();错误
        //(4)最终运行效果看子类(运行类型)的具体实现，即调用方法时，按照从子类(运行类型)开始查找方法
        //，然后调用，规则和前面调用规则一致。
        animal.eat();//猫吃鱼...
        animal.run();//跑
        animal.show();//hello,你好
        animal.sleep();//睡

        //多态的向下转型
        //(1)语法：子类类型   引用名 = （子类类型）父类引用；

        //cat 的编译类型 Cat，运行类型是Cat
        Cat cat =(Cat) animal;
        cat.catchMouse();
        //(2)要求父类的引用必须指向的是当前目标类型的对象
        //Dog dog = (Dog) animal;

    }
}
