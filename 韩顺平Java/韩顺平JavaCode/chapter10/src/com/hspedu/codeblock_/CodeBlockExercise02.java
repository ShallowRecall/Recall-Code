package com.hspedu.codeblock_;

public class CodeBlockExercise02 {
    public static void main(String[] args) {
        Test test = new Test();//无参构造器
    }
}
class Sample{
    Sample(String s){
        System.out.println(s);
    }
    Sample(){
        System.out.println("Sample默认构造函数被调用");
    }
}
class Test{
    Sample sam1 = new Sample("sma1成员初始化");
    static Sample sam = new Sample("静态成员sam初始化");
    static {
        System.out.println("static块执行");
        if (sam == null)
            System.out.println("sam is null");
    }
    Test(){
        System.out.println("Test默认构造函数被调用");
    }
}
/*
1.静态成员sam初始化
2.static块执行
3.sma1成员初始化
4.Test默认构造函数被调用
 */