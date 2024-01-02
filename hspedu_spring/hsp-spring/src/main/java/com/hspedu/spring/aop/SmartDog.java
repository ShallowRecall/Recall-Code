package com.hspedu.spring.aop;

import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component
public class SmartDog implements SmartAnimalable {
    @Override
    public float getSum(float i, float j) {
        float res = i + j;
        System.out.println("SmartDog-getSum-res=" + res);
        return res;
    }

    @Override
    public float getSub(float i, float j) {
        float res = i - j;
        System.out.println("SmartDog-getSum-res=" + res);
        return res;
    }
}
