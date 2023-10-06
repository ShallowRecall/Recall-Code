package com.hspedu.throws_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class Throws01 {
    public static void main(String[] args) {

    }

    public void f2() throws FileNotFoundException {
        //创建了一个文件流对象
        //解读：
        // 1.这里的异常是一个FileNotFoundException 编译异常
        // 2.使用前面讲过的 try-catch-finally
        // 3.使用throws，抛出异常,让调用f2方法的调用者(方法)处理
        FileInputStream fis = new FileInputStream("d://aa.txt");
    }
}
