package com.hspedu.super_;

public class B extends A {

    public int n1 = 888;

    //编写测试方法
    public void test(){
        System.out.println("super.n1="+super.n1);
        super.cal();
    }
    //访问父类的属性，但不能访问父类的private属性
    //super.属性名;
    public void hi() {
        System.out.println(super.n1 + " " + super.n2 + " " + super.n3);
    }
    public void cal(){
        System.out.println("B类的cal() 方法...");
    }
    public void sum(){
        System.out.println("B类的sum()");
        //希望调用父类-A 的cal方法
        //这时，因为子类B没有cal方法，因此可以使用下面三种方式

        //找cal方法时(cal() 和 this.cal())，顺序是，
        // (1)先找本类，如果有，则调用
        // (2)如果没有，则找父类(如果有，并可调用，则调用)
        // (3)如果父类没有，则继续找父类的父类，整个规则，就是一样的,直到 Object类
        // 提示：如果查找方法的过程中，找到了，但是不能访问，则报错 cannot access
        //      如果查找方法的过程中，没有找到，则提示方法不存在
        //cal();
        this.cal(); //等价 cal
        //找cal方法(super.call()) 的顺序是直接查找父类，其他的规则一样
        //super.cal();

        //演示访问属性的规则
        //n1 和 this.n1 查找的规则是
        //(1) 先找本类，如果有，则调用
        //(2) 如果没有，则找父类（如果有，并可以调用，则调用）
        //(3) 如果父类没有，则继续找父类的父类，整个规则，就是这样，直到 Object类
        // 提示：如果查找属性的过程中，找到了，但是不能访问，则报错 cannot access
        //      如果查找属性的过程中，没有找到，则提示属性不存在
        System.out.println(n1);
        System.out.println(this.n1);

        //找n1 (super.n1) 的顺序是直接查找父类属性，其他的规则一样
        System.out.println(super.n1);


    }

    //访问父类的方法，不能访问父类的private方法
    //super.方法名(参数列表);
    public void ok(){
        super.test100();
        super.test200();
        super.test300();
        //super.test400();//不能访问父类private方法
    }
    //访问父类的构造器
    //super(参数列表);只能放在构造器的第一句，只能出现一句！
    public B(){
        //super();
        //super("jack",10);
        super("jack");
    }
}
