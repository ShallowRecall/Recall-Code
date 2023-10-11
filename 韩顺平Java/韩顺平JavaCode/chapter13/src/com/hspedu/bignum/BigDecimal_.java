package com.hspedu.bignum;

import java.math.BigDecimal;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class BigDecimal_ {
    public static void main(String[] args) {
        //当我想保存一个精度很高的数时，double 不够用
        //可以1使用 BigDecimal
//        double d = 1999.11111111111199999999999;
//        System.out.println(d);

        BigDecimal bigDecimal = new BigDecimal("1999.11111111111199999999999777779998888888");
        BigDecimal bigDecimal2 = new BigDecimal("1.1");
        System.out.println(bigDecimal);

        //解读
        //1. 如果对 BigDecimal进行运算，比如加、减、乘、除，需要使用对应的方法
        //2. 创建一个需要操作的 BigDecimal 然后调相应的方法即可
        System.out.println(bigDecimal.add(bigDecimal2));
        System.out.println(bigDecimal.subtract(bigDecimal2));
        System.out.println(bigDecimal.multiply(bigDecimal2));
//        System.out.println(bigDecimal.divide(bigDecimal2));//可能抛出异常ArithmeticException
        //在调用divide 方法时，指定精度即可. BigDecimal.ROUND_CEILING
        //如果有无限循环小数，就会保留 分子 的精度
        System.out.println(bigDecimal.divide(bigDecimal2,BigDecimal.ROUND_CEILING));//可能抛出异常ArithmeticException
    }
}
