package com.hspedu.poly_;

public class PloyMethod {
    public static void main(String[] args) {
        //方法重载体现多态
        A a = new A();
        //这里我们传入不同的参数，就会调用不同sum方法，就体现多态
        System.out.println(a.sum(10,30));
        System.out.println(a.sum(10,30,50));

        //方法的重写体现多态
        B b = new B();
        a.say();
        b.say();
    }
}

class B {
    public void say(){
        System.out.println("B say() 方法被调用...");
    }
}

class A extends B{
    public int sum(int n1,int n2){
        return n1+n2;
    }
    public int sum(int n1,int n2,int n3){
        return n1+n2+n3;
    }
    public void say(){
        System.out.println("A say() 方法被调用...");
    }
}
