package com.hspedu.tankgame3;

import com.hspedu.tankgame3.EnemyTank;
import com.hspedu.tankgame3.Hero;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;

/**
 * @author ZhouYu
 * @version 1.0
 * 坦克大战的绘图区域
 */

//为了监听 键盘事件， 实现KeyListener
//为了让Panel 不停的重绘，需要将 MyPanel 实现Runnable ，当做一个线程使用
public class MyPanel extends JPanel implements KeyListener,Runnable{
    //定义我的坦克
    Hero hero = null;
    //定义敌人坦克，放入到Vector
    Vector<EnemyTank> enemyTanks = new Vector<>();
    int enemyTankSize = 3;

    public MyPanel() {
        hero = new Hero(100, 100);//初始化自己的坦克
        hero.setSpeed(2);
        //初始化敌人的坦克
        for (int i = 0; i < enemyTankSize; i++) {
            //创建一个敌人的坦克
            EnemyTank enemyTank = new EnemyTank(100 * (i + 1), 0);
            //设置方向
            enemyTank.setDirect(2);
            //加入
            enemyTanks.add(enemyTank);
        }

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0, 0, 1000, 750);//填充矩形，默认是黑色

        //画出坦克-封装方法
        drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 1);

        //画出Hero射击的子弹
        if (hero.shot != null && hero.shot.isLive != false){
            System.out.println("子弹被绘制...");
            g.draw3DRect(hero.shot.x,hero.shot.y,1,1,false);
        }

//        drawTank(hero.getX() + 60, hero.getY(), g, 0, 0);
        //画出敌人的坦克,遍历Vector
        for (int i = 0; i < enemyTanks.size(); i++) {
            //取出坦克
            EnemyTank enemyTank = enemyTanks.get(i);
            drawTank(enemyTank.getX(), enemyTank.getY(), g, enemyTank.getDirect(), 0);
        }
    }

    //编写方法，画出坦克

    /**
     * @param x      坦克的左上角x坐标
     * @param y      坦克的左上角y坐标
     * @param g      画笔
     * @param direct 坦克方向(上下左右)
     * @param type   坦克类型
     */
    public void drawTank(int x, int y, Graphics g, int direct, int type) {
        //根据不同类型坦克，设置不同颜色
        switch (type) {
            case 0: //敌人坦克
                g.setColor(Color.cyan);
                break;
            case 1: //我的坦克
                g.setColor(Color.yellow);
                break;
        }

        //根据坦克的方向，来绘制对应形状坦克
        //direct 表示方向(0： 向上 1：向右 2：向下 3：向左)
        switch (direct) {
            case 0://表示向上
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的身体
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形的盖子
                g.drawLine(x + 20, y + 30, x + 20, y - 5);//画出坦克的炮筒
                break;
            case 1://向右
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的身体
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆形的盖子
                g.drawLine(x + 30, y + 20, x + 65, y + 20);//画出坦克的炮筒
                break;
            case 2://向下
                g.fill3DRect(x, y, 10, 60, false);//画出坦克左边的轮子
                g.fill3DRect(x + 30, y, 10, 60, false);//画出坦克右边的轮子
                g.fill3DRect(x + 10, y + 10, 20, 40, false);//画出坦克的身体
                g.fillOval(x + 10, y + 20, 20, 20);//画出坦克圆形的盖子
                g.drawLine(x + 20, y + 30, x + 20, y + 65);//画出坦克的炮筒
                break;
            case 3://向左
                g.fill3DRect(x, y, 60, 10, false);//画出坦克上边的轮子
                g.fill3DRect(x, y + 30, 60, 10, false);//画出坦克下边的轮子
                g.fill3DRect(x + 10, y + 10, 40, 20, false);//画出坦克的身体
                g.fillOval(x + 20, y + 10, 20, 20);//画出坦克圆形的盖子
                g.drawLine(x + 30, y + 20, x - 5, y + 20);//画出坦克的炮筒
            default:
                System.out.println("暂时没有处理");
        }

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    //处理wdsa 键按下的情况
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {//按下w键
            //改变坦克的方向
            hero.setDirect(0);
            //修改坦克的坐标 y-=1
            hero.moveUp();
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            hero.setDirect(1);
            hero.moveRight();
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            hero.setDirect(2);
            hero.moveDown();
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            hero.setDirect(3);
            hero.moveLeft();
        }

        //如果用户按下的是J，就发射
        if (e.getKeyCode() == KeyEvent.VK_J){
            System.out.println("用户按下了J,开始射击.");
            hero.shotEnemyTank();
        }
        //让面板重绘
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() { //每隔100毫秒，重绘区域
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.repaint();
    }
}
