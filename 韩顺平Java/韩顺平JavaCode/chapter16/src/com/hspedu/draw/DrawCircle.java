package com.hspedu.draw;

import javax.swing.*;
import java.awt.*;

/**
 * @author Zhou Yu
 * @version 1.0
 * 演示如何在面板上画出圆形
 */
@SuppressWarnings({"all"})
public class DrawCircle extends JFrame{//JFrame对应一个窗口,可以理解成一个画框

    //定义一个面板
    private MyPanel mp=null;
    public static void main(String[] args) {
        new DrawCircle();
    }

    public DrawCircle(){//构造器
        //初始化面板
        mp = new MyPanel();
        //把面板放入到窗口(画框)
        this.add(mp);
        //设置窗口大小
        this.setSize(400,300);
        this.setVisible(true);//可以显示
    }

}

//1. 先定义一个MyPanel(),继承JPanel类，画图形，就在面板上画
class MyPanel extends JPanel {

    //说明：
    //1. MyPanel 对象就是一个面板
    //2. Graphics g 把 g 理解成一支画笔
    //3. Graphics 提供了很多绘画的方法
    //Graphics
    @Override
    public void paint(Graphics g) {//绘图方法
        super.paint(g);//调用父类的方法完成初始化.
        //System.out.println("paint 方法被调用了~");
        //画出一个圆形
        g.drawOval(10,10,100,100);
    }
}
