package com.hspedu.outputstream_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FileCopy {
    public static void main(String[] args) {
        //完成 文件拷贝，将 src/textFiles/dog.jpg 拷贝到 src/textFiles/demo/a/b/c
        //思路分析
        //1. 创建文件的输入流，将文件读入到程序
        //2. 创建文件的输出流，将读取到的文件数据，写入到指定路径。
        String srcFilePath = "src/textFiles/dog.jpg";
        String destFilePath = "src/textFiles/demo/a/b/c/dog.jpg";
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(srcFilePath);
            fileOutputStream = new FileOutputStream(destFilePath);
            //定义一个字节数组，提高读取效率
            byte[] buf = new byte[1024];
            int readLen = 0;
            while ((readLen = fileInputStream.read(buf)) != -1) {
                //读取到后，就写入到文件 通过 fileOutputStream
                //即，是一边读一边写
                fileOutputStream.write(buf, 0, readLen);//一定要使用这个方法

            }
            System.out.println("拷贝ok~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                //关闭输入流和输出流，释放资源
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}
