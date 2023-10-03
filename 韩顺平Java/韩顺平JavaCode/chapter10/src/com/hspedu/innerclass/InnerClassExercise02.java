package com.hspedu.innerclass;

public class InnerClassExercise02 {
    public static void main(String[] args) {
        CallPhone callPhone = new CallPhone();
        callPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("懒猪起床了");
            }
        });

        callPhone.alarmClock(new Bell() {
            @Override
            public void ring() {
                System.out.println("小伙伴上课了");
            }
        });
    }
}
interface Bell{//接口
    void ring();//方法
}
class CallPhone{//类
    public void alarmClock(Bell bell){//形参是Bell接口类型
        bell.ring();
    }
}