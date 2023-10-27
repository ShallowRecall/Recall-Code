package com.hspedu.method;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaemonThread myDaemonThread = new MyDaemonThread();
        //如果我们希望主线程结束后，子线程自动结束
        //，只需将子线程设为守护线程即可
        myDaemonThread.setDaemon(true);
        myDaemonThread.start();
        for (int i = 1; i <= 10 ; i++) {//main线程
            System.out.println("王宝强在辛苦的工作...");
            Thread.sleep(1000);
        }
    }
}

class MyDaemonThread extends Thread {
    @Override
    public void run() {
        for (; ;){
            try {
                Thread.sleep(1000);//休眠1000毫秒
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("马蓉和宋喆快乐聊天，哈哈哈~~~");
        }
    }
}