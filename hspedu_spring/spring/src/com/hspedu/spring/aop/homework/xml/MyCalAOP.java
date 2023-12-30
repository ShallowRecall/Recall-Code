package com.hspedu.spring.aop.homework.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;

import java.time.LocalDateTime;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class MyCalAOP {

    //前置通知
    public void CalStart(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " 基于XML配置- 执行，开始执行时间=" + System.currentTimeMillis());
        System.out.println(signature.getName() + " 基于XML配置- 执行，开始执行时间=" + LocalDateTime.now());
    }


    //返回通知
    public void CalEnd(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        System.out.println(signature.getName() + " 基于XML配置- 执行，结束时间=" + System.currentTimeMillis());
        System.out.println(signature.getName() + " 基于XML配置- 执行，结束时间=" + LocalDateTime.now());
    }
}
