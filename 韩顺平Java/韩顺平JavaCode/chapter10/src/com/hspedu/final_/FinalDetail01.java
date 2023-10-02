package com.hspedu.final_;

public class FinalDetail01 {
    public static void main(String[] args) {
        CC cc = new CC();

        new EE().cal();
    }
}

class AA {
    /*
    - 定义时：如public final double TAX_RATE = 0.08;
    - 在构造器中
    - 在代码块中
     */
    public final double TAX_RATE = 0.08;//1.定义时赋值
    public final double TAX_RATE2;
    public final double TAX_RATE3;

    public AA() {//构造器中赋值
        TAX_RATE2 = 1.1;
    }

    {//代码块赋值
        TAX_RATE3 = 8.8;
    }
}

class BB {
    /*
    如果final修饰的属性是静态的，则初始化的位置只能是
    - 定义时
    - 在静态代码块 不能在构造器中赋值
     */
    public static final double TAX_RATE = 99.9;
    public static final double TAX_RATE2;

//    public static final double TAX_RATE3;
//
//    public BB(){
//        TAX_RATE3 = 8.8;
//    }

    static {
        TAX_RATE2 = 3.3;
    }
}

//final类不能继承，但是可以实例化对象
final class CC {
}

//如果类不是final类，但是含有final方法，则该方法虽然不能重新，但是可以被继承。
//即，仍然遵守继承的机制
class DD {
    public final void cal() {
        System.out.println("cal()方法");
    }
}

class EE extends DD {

}