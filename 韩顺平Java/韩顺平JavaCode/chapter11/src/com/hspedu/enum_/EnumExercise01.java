package com.hspedu.enum_;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class EnumExercise01 {
    public static void main(String[] args) {
        Gender2 boy = Gender2.BOY;//OK
        Gender2 boy2 = Gender2.BOY;//OK
        System.out.println(boy);
        System.out.println(boy2 == boy);//True
    }
}

enum Gender2{//父类 Enum 的toString
    BOY,GIRL;
}