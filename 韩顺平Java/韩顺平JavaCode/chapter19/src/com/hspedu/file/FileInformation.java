package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FileInformation {
    public static void main(String[] args) {

    }

    //获取文件的信息
    @Test
    public void info() {
        //先创建文件对象
        File file = new File("/Users/zhouyu/Recall-Code/韩顺平Java/韩顺平JavaCode/chapter19/src/textFiles/news1.txt");

        File file1 = new File("src/textFiles/news2.txt");
        //调用相应的方法，得到对应信息
        System.out.println("文件名字=" + file.getName());
        /*
        getName、getAbsolutePath、getParent、length、exists、isFile、isDirectory
         */
        System.out.println("文件绝对路径=" + file1.getAbsolutePath());
        System.out.println("文件父级目录=" + file1.getParent());
        System.out.println("文件大小(字节)=" + file1.length());
        System.out.println("文件是否存在=" + file1.exists());//T
        System.out.println("是不是一个文件=" + file1.isFile());//T
        System.out.println("是不是一个目录=" + file1.isDirectory());//F
    }
}
