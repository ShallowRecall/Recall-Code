package com.hspedu.interface_;

public class InterfacePolyArr {
    public static void main(String[] args) {


        //多态数组 -> 接口数组
        Usb[] usbs = new Usb[2];
        usbs[0] =new Phone_();
        usbs[1] =new Camera_();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();//动态绑定..
            if (usbs[i] instanceof Phone_){//判断他的运行类型是 Phone_
                ((Phone_) usbs[i]).call();
            }
        }

    }
}

interface Usb{
    void work();
}
class Phone_ implements Usb {
    public void call(){
        System.out.println("手机可以打电话...");
    }

    @Override
    public void work() {
        System.out.println("手机工作中...");
    }
}
class Camera_ implements Usb {
    @Override
    public void work() {
        System.out.println("相机工作中...");
    }
}