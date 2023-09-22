package com.hspedu.override_;

public class Animal {
    public void cry() {
        System.out.println("动物叫唤..");
    }

    public Object m1(){
        return null;
    }

    public String m2(){
        return null;
    }

    public AAA m3(){
        return null;
    }

    //细节：子类方法不能缩小父类方法的访问权限
    //public > protected > 默认 > private
    protected void eat(){

    }
}
