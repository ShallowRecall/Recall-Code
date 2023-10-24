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
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //g.drawOval(10,10,100,100);

        //演示绘制出不同的图形...
        //画直线
        //g.drawLine(10, 10, 100, 100);
        //画出矩形边框
        //g.drawRect(10,10, 100, 100);
        //填充矩形
        //设置画笔的颜色
//        g.setColor(Color.blue);
//        g.fillRect(10, 10,100,100);
        //填充椭圆
//        g.setColor(Color.red);
//        g.fillOval(10, 10, 100, 100);

        //画图片
        //1. 获取图片资源, /bg.png 表示在该项目的根目录去获取 bg.png 图片资源
//        Image image = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("/bg.png"));
//        g.drawImage(image, 10, 10, 500,333,this);
        //画字符串
        //给画笔设置颜色和字体
        g.setColor(Color.red);
        g.setFont(new Font("隶书", Font.BOLD, 50));
        //这里设置的 100，,100，是"北京你好"左下角
        g.drawString("北京你好", 100, 100);

    }
}
