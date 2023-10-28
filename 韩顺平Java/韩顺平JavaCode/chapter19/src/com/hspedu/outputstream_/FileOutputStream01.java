package com.hspedu.outputstream_;

import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FileOutputStream01 {
    public static void main(String[] args) {

    }

    /**
     * 演示使用OutputStream 将数据写到文件中，
     * 如果该文件不存在，则创建该文件
     */
    @Test
    public void writeFile(){

        //创建 FileOutPutStream对象

        String filePath = "src/textFiles/a.txt";
        FileOutputStream fileOutputStream = null;
        try {
            //得到 FileOutPutStream对象  对象
            //说明
            //1. new FileOutputStream(filePath) 创建方式，当写入内容时，会覆盖原来的内容
            //2. new FileOutputStream(filePath, true) 创建方式，当写入内容时，是追加到文件后面
            fileOutputStream = new FileOutputStream(filePath,true);
            //写入一个字节
//            fileOutputStream.write('H');//
            //写入字符串
            String str = "hsp,world!";
            //str.getBytes() 可以把字符串-> 字节数组
//            fileOutputStream.write(str.getBytes());
            /*
            write(byte[] b, int off,int len) 将 len字节从位于偏移量 off的指定字节数组写入
            此文件输出流
             */
            fileOutputStream.write(str.getBytes(),0,str.length());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
