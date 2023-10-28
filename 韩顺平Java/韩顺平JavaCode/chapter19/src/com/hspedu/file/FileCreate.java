package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.Reader;

/**
 * @author ZhouYu
 * @version 1.0
 * 演示创建文件
 */
public class FileCreate {
    public static void main(String[] args) {

    }

    @Test
    //方式1 new File(String pathname)
    public void create01() {
        String filePath = "/Users/zhouyu/Recall-Code/韩顺平Java/韩顺平JavaCode/chapter19/src/textFiles/news1.txt";
        File file = new File(filePath);

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式2 new File(File parent,String child) //根据父目录文件+子路径创建
    ///Users/zhouyu/Recall-Code/韩顺平Java/韩顺平JavaCode/chapter19/src/textFiles
    @Test
    public void create02() {
        File parentFile = new File("/Users/zhouyu/Recall-Code/韩顺平Java/韩顺平JavaCode/chapter19/src/textFiles");
        //这里的file对象，在java程序中，只是一个对象
        //只有执行了createNewFile 方法，才会真正的，在磁盘创建该文件
        String fileName = "news2.txt";
        File file = new File(parentFile, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Test
    //方式3 new File(String parent,String child) //根据父目录+子路径构建
    public void create03() {
        String parentPath = "/Users/zhouyu/Recall-Code/韩顺平Java/韩顺平JavaCode/chapter19/src/textFiles";
        String fileName = "news3.txt";
        File file = new File(parentPath, fileName);

        try {
            file.createNewFile();
            System.out.println("创建成功~");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    //下面四个都是抽象类

    //InputStream
    //OutputStream
    //Reader //字符输入流
    //Writer //字符输出流

}
