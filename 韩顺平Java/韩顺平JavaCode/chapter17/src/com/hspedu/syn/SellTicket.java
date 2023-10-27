package com.hspedu.syn;

/**
 * @author ZhouYu
 * @version 1.0
 * 使用多线程模拟三个窗口同时售票100张
 */
public class SellTicket {
    public static void main(String[] args) {
        //测试
//        SellTicket01 sellTicket01 = new SellTicket01();
//        SellTicket01 sellTicket02 = new SellTicket01();
//        SellTicket01 sellTicket03 = new SellTicket01();
//
//        //这里会出现票数超卖
//        sellTicket01.start();
//        sellTicket02.start();
//        sellTicket03.start();

//        System.out.println("===使用实现接口的方式来售票===");
//        SellTicket02 sellTicket02 = new SellTicket02();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();
//        new Thread(sellTicket02).start();

        //测试
        SellTicket03 sellTicket03 = new SellTicket03();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
        new Thread(sellTicket03).start();
    }
}


//实现接口方式，使用synchronized实现线程同步
class SellTicket03 implements Runnable {

    private int ticketNum = 100;//让多个线程共享 ticketNum
    private Boolean loop = true;//控制run方法变量

    Object object = new Object();

    //同步方法(静态的)的锁为当前类本身
    //解读
    //1. public synchronized static void m1(){} 锁加在 SellTicket03.class
    //2. 如果在静态方法中，实现一个同步代码块
    /*
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
     */
    public synchronized static void m1(){

    }
    public static void m2 (){
        synchronized (SellTicket03.class) {
            System.out.println("m2");
        }
    }

    //说明：
    //1. public synchronized void sell() {} 就是一个同步方法
    //2. 这时锁在 this对象
    //3. 也可以在代码块上写 synchronized，同步代码块，互斥锁还是在this对象

    public /*synchronized*/ void sell() {//同步方法，在同一时刻，只能有一个线程来执行run方法

        synchronized (object/*this*/) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                loop = false;
                return;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));
        }
    }

    @Override
    public void run() {

        while (loop) {

            sell();//sell方法时一个同步方法
        }

    }
}


//使用Thread方式
// new SellTicket01().start()
// new SellTicket01().start()
class SellTicket01 extends Thread {

    private static int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {

        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));

        }

    }
}

class SellTicket02 implements Runnable {

    private int ticketNum = 100;//让多个线程共享 ticketNum

    @Override
    public void run() {

        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束...");
                break;
            }

            //休眠50毫秒
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口 " + Thread.currentThread().getName() + " 售出一张票" +
                    " 剩余票数=" + (--ticketNum));

        }

    }
}
