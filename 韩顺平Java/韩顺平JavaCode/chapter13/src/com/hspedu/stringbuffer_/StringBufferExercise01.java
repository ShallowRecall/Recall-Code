package com.hspedu.stringbuffer_;

public class StringBufferExercise01 {
    public static void main(String[] args) {
        String str = null;//ok
        StringBuffer sb = new StringBuffer();//ok
        sb.append(str);//底层调用的是AbstractStringBuilder 的 appendNull
        System.out.println(sb.length());//4

        System.out.println(sb);//null
        //下面的构造器，会抛出 NullpointerException
        StringBuffer sb1 = new StringBuffer(str);//底层super(str.length() + 16);
        System.out.println(sb1);
    }
}
