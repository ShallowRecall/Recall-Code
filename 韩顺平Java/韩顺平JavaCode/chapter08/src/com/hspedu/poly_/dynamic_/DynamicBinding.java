package com.hspedu.poly_.dynamic_;

public class DynamicBinding {
    public static void main(String[] args) {
        //a 的编译类型 A,运行类型 B
        A a = new B();//向上转型
        System.out.println(a.sum());//30
        System.out.println(a.sum1());//20
    }
}

class A {
    public int i = 10;
    //动态绑定机制：

    public int sum() {
        return getI() + 10;
    }

    public int sum1() {
        return i + 10;//10 + 10
    }

    public int getI() {//父类getI()
        return i;
    }
}

class B extends A {
    public int i = 20;

//    public int sum() {
//        return i + 20;
//    }

    public int getI() {//子类getI()
        return i;
    }

//    public int sum1() {
//        return i + 10;
//    }
}
