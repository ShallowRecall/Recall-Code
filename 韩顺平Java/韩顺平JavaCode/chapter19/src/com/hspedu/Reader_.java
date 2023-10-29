package com.hspedu;

/**
 * @author ZhouYu
 * @version 1.0
 */
public abstract class Reader_ { // 抽象类

    public void readFile() {
    }

    public void readString() {
    }

    //在Reader_ 抽象类，使用read 方法统一管理.
    //后面在调用时，利用对象动态绑定机制，来绑定到对应的实现子类即可
//    public abstract void read();
}

