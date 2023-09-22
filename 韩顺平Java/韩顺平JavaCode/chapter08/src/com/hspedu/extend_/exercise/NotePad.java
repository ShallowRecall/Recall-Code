package com.hspedu.extend_.exercise;

public class NotePad extends Computer {
    String color;

    public NotePad(String cpu, int memory, int disk, String color) {
        super(cpu, memory, disk);
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void printInfo() {
        System.out.println("NotePad信息=");
        //System.out.println(getCpu() + getMemory() + getDisk());
        //调用父类的getDetail方法，得到相关属性信息
        System.out.println(getDetail() + " color=" + color);
    }
}
