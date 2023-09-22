package com.hspedu.poly_;

public class Poly01 {
    public static void main(String[] args) {
        Master master = new Master("Recall");
        Dog dog = new Dog("大黄");
        Bone bone = new Bone("大棒骨");
        master.feed(dog, bone);
    }
}
