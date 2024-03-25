package com.hspedu.furn.lambda;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class Test {
    public static void main(String[] args) {

        //传统的方式来实现HspFunction/得到一个实现接口的对象 可以使用
        // 匿名类部分类
        /*HspFunction<Desk, String> hf = new HspFunction<Desk, String>() {
            @Override
            public String apply(Desk desk) {
                return "hello desk";
            }
        };

        String val = hf.apply(new Desk());
        System.out.println("val-" + val);*/

        HspFunction<Desk, String> hf2 = Desk::getBrand;

        String val2 = hf2.apply(new Desk());
        System.out.println("val2-" + val2);

        HspFunction<Desk, Integer> hf3 = Desk::getId;
    }
}

//定义一个函数式接口：有且只有一个抽象方法的接口
//我们可以使用@FunctionalInterface 来标识一个函数式接口
//HspFunction是函数式接口（是自定义泛型接口）

@FunctionalInterface
interface HspFunction<T, R> {
    R apply(T t); //抽象方法：表示根据类型T的类型，获取类型R的结果

    //函数式接口，依然可以有多个默认实现方法
    default public void ok() {
        System.out.println("ok");
    }
}

@FunctionalInterface
interface HspInterface<T, R> {
    public void hi();
}

class Desk { //Bean
    private String name = "hsp desk";
    private String brand = "北京牌";
    private Integer id = 10;


    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getId() {
        return id;
    }

    public void hello(){
        System.out.println("xxx");
    }
}


