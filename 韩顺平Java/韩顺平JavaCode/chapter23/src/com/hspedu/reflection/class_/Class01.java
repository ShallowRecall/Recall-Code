package com.hspedu.reflection.class_;

import com.hspedu.Cat;

/**
 * @author ZhouYu
 * @version 1.0
 * 对Class类特点的梳理
 */
public class Class01 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1. Class也是类，因此也继承Object类
        //Class
        //2. Class类对象不是new出来的，而是系统创建的
        //(1) 传统new对象
        /*  ClassLoader类
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
//        Cat cat = new Cat();
        //(2) 反射方式 没有注销Cat cat = new Cat()，会导致无法追到loadClass，因为类的加载只会有一次
        /*
             ClassLoader类，仍然是通过 ClassLoader类加载Cat类的 Class对象
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                return loadClass(name, false);
            }
         */
        Class cls1 = Class.forName("com.hspedu.Cat");

        //3.对于某个类的Class类对象，在内存中只有一份，因此类只加载一次
        Class cls2 = Class.forName("com.hspedu.Cat");
        System.out.println(cls1.hashCode());
        System.out.println(cls2.hashCode());
        Class cls3 = Class.forName("com.hspedu.Dog");
        System.out.println(cls3.hashCode());
    }
}
