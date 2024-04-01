package com.hspedu.springcloud;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;

import java.util.function.Function;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class T1 {


    public static void main(String[] args) {

       /* // 这是lambda表达式的第一种形式
        Dog dog = T1.hi("小花猫", (String str) -> {
            Cat cat = new Cat();
            cat.setName(str);
            return cat;
        });*/

        /*//对上面的lambda表达式进行简写
        Dog dog = T1.hi("小花猫", str -> {
            Cat cat = new Cat();
            cat.setName(str);
            return cat;
        });*/

        /*//对上面的lambda表达式进行简写
        Dog dog = T1.hi("小花猫", str -> {
            return new Cat(str);
        });*/

        //对上面的lambda表达式进行简写
        Dog dog = T1.hi("小花猫", str -> new Cat(str));
        System.out.println(dog);
    }


    //模拟把 Cat -> Dog
    public static Dog hi(String str, Function<String, Cat> fn) {
        Cat cat = fn.apply(str);
        Dog dog = new Dog();
        dog.setName(cat.getName() + " ~变成了小狗名字");
        return dog;
    }
}

class Dog {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                '}';
    }
}

class Cat {
    private String name;

    public Cat() {
    }

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}