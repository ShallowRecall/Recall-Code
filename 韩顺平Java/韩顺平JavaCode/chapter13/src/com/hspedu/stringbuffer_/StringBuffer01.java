package com.hspedu.stringbuffer_;

public class StringBuffer01 {
    public static void main(String[] args) {
        //解读
        //1. StringBuffer 的直接父类 是 AbstractStringBuilder
        //2. StringBuffer 实现了 Serializable,即StringBuffer的对象可以串行化
        //3. 在父类中 AbstractStringBuilder 有属性 char[] value,不是final
        //   该 value 数组存放 字符串内容，因此存放在堆中的
        //4. StringBuffer 是一个final类，不能被继承
        //5. 因为StringBuffer 字符内容是存在 char[] value，所以在变化(增加/删除)
        //   不用每次都更换地址(即不是每次都创建新对象)，所以效率高于 String
        StringBuffer stringBuffer = new StringBuffer();
//        String str = "hello";
//        System.out.println(str.hashCode());
//        str = "hello".concat("i");
//        System.out.println(str.hashCode());
//        System.out.println(str);
    }
}
