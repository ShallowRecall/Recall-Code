package com.hspedu.stringbuffer_;

public class StringBufferExercise02 {
    public static void main(String[] args) {
        /*
        思路分析
        1. 定义一个Scanner 对象，接收用户输入的 价格(String)
        2. 希望使用到 StringBuffer的 insert, 需要将 String 转成 StringBuffer
        3. 然后使用相关方法进行字符串的处理
        代码实现
         */

        String price = "8123564.59";
        StringBuffer sb = new StringBuffer(price);
        //先完成一个最简单的实现123,564.59
        //找到小数点的索引，然后在该位置的前三位，插入，即可
        //int i = sb.lastIndexOf(".");
        //sb = sb.insert(i-3,",");

        //上面的两步需要做一个循环处理，才是正确的
        for(int i = sb.lastIndexOf(".");i > 3;i-=3){
            sb = sb.insert(i-3,",");
        }
        System.out.println(sb);//123,564.59
//        int pointIndex = price.indexOf('.');
//        System.out.println(pointIndex);
//        while (true){
//            pointIndex-=3;
//            if (pointIndex <= 0){
//                break;
//            }
//            sb.insert(pointIndex,',');
//        }
//        System.out.println("sb="+sb);
    }
}
