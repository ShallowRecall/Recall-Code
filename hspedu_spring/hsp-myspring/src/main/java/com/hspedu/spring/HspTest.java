package com.hspedu.spring;

import com.hspedu.spring.annotation.AfterReturning;
import com.hspedu.spring.annotation.Before;
import com.hspedu.spring.component.SmartAnimalAspect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class HspTest {
    public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        //1. 获取SmartAnimalAspect的class对象
        Class<SmartAnimalAspect> smartAnimalAspectClass = SmartAnimalAspect.class;
        //2. 遍历该类的所有方法
        for (Method declaredMethod : smartAnimalAspectClass.getDeclaredMethods()) {
            //如果切面类的方法有Before注解
            if (declaredMethod.isAnnotationPresent(Before.class)) {
                //得到切面类的切入方法名
                System.out.println("m:= " + declaredMethod.getName());
                //得到Before(value="xxxx")
                //得到Before注解
                Before annotation = declaredMethod.getAnnotation(Before.class);
                //得到Before注解的value
                System.out.println("value:= " + annotation.value());

                //得到切入要执行的方法.[反射基础]
                Method declaredMethod1 = smartAnimalAspectClass.getDeclaredMethod(declaredMethod.getName());
                //调用切入方法[通过反射调用]
                declaredMethod1.invoke(smartAnimalAspectClass.newInstance(), null);

            } else if (declaredMethod.isAnnotationPresent(AfterReturning.class)) {

                //如果发现切面类有AfterReturning注解，同样可以进行处理..
                System.out.println("m:= " + declaredMethod.getName());
                AfterReturning annotation = declaredMethod.getAnnotation(AfterReturning.class);
                System.out.println("value:= " + annotation.value());

                //得到切入要执行的方法.
                Method declaredMethod1 = smartAnimalAspectClass.getDeclaredMethod(declaredMethod.getName());
                //调用切入方法[反射调用]
                declaredMethod1.invoke(smartAnimalAspectClass.newInstance(), null);
            }
        }
    }
}
