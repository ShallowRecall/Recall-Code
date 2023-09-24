package com.hspedu.smallchange.OOP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * 该类是完成零钱通的各个功能的类
 * 使用OOP(面向对象编程)
 * 将各个功能对应一个方法
 */
public class SmallChangeSysOOP {

    //属性..
    //定义相关的变量
    boolean loop = true;
    Scanner scanner = new Scanner(System.in);
    String key = "";

    //2. 完成零钱通明细
    //思路 (1) 可以把收益入账和消费，保存到数组 (2) 可以使用对象 (3) 简单的话可以使用String拼接
    String details = "--------------零钱通明细--------------";

    //3.完成收益入账  完成功能驱动程序员增加新的变化和代码
    //思路，定义新的变量
    double money = 0;
    double balance = 0;
    Date date = null;// date 是 java.util>date 类型,表示日期
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");//用于日期格式化的

    //4. 消费
    //定义新变量，保存消费的原因
    String note = "";

    //先完成显示菜单，并可以选择
    public void mainMenu(){
        do {
            System.out.println("\n===============选择零钱通菜单===============");
            System.out.println("\t\t\t1 零钱通明细");
            System.out.println("\t\t\t2 收益入账");
            System.out.println("\t\t\t3 消费");
            System.out.println("\t\t\t4 退     出");

            System.out.println("请选择(1-4)：");
            key = scanner.next();

            //使用switch 分支控制

            switch (key) {
                case "1":
                    this.detail();
                    break;
                case "2":
                    this.income();
                    break;
                case "3":
                    this.pay();
                    break;
                case "4":
                    this.exit();
                    break;
                default:
                    System.out.println("选择有误,请重新选择");
            }
        } while (loop);
    }

    //完成零钱通明细
    public void detail(){
        System.out.println(details);
    }
    //完成收益入账
    public void income(){
        System.out.print("收益入账金额：");
        money = scanner.nextDouble();
        //money 的值范围应该校验
        //思路：编程思想
        //找出不正确的金额条件，然后给出提示，就直接break
        if (money <= 0) {
            System.out.println("收益入账金额 需要 大于 0");
            return;//退出方法，不再执行后面的代码。
        }
        balance += money;
        //拼接收益入账信息到 details
        date = new Date();//获取当前日期
        details += "\n收益入账\t+" + money + "\t " + sdf.format(date) + "\t" + balance;
    }
    //消费
    public void pay(){
        System.out.println("消费金额:");
        money = scanner.nextDouble();
        //money 的值范围应该校验
        //找出金额不正确的情况
        //过关斩将 校验方式.
        if (money <= 0 || money > balance) {
            System.out.println("你的消费金额 应该在 0-" + balance);
            return;
        }
        System.out.println("消费说明:");
        note = scanner.next();
        balance -= money;
        //拼接消费信息到 details
        date = new Date();//获取当前日期
        details += "\n" + note + "\t-" + money + "\t " + sdf.format(date) + "\t" + balance;
    }

    //退出
    public void exit(){
        String choice = "";
        while (true) {//要求用户必须输入y/n，否则就一直循环
            System.out.println("你确定要退出吗？y/n");
            choice = scanner.next();
            if ("y".equals(choice) || "n".equals(choice)) {
                break;
            }
            //第二个方案
//                        if ("y".equals(choice)){
//                            loop = false;
//                            break;
//                        }else if ("n".equals(choice)){
//                            break;
//                        }
        }
        //当用户退出while 后
        if (choice.equals("y")) {
            loop = false;
        }
    }
}
