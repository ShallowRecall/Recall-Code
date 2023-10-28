package com.hspedu.reader_;

import org.junit.jupiter.api.Test;

import javax.imageio.IIOException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class FileReader_ {
    public static void main(String[] args) {


    }

    /**
     * 单个字符读取文件
     */
    @Test
    public void readFile01() {
        String filePath = "src/textFiles/story.txt";
        FileReader fileReader = null;
        int data = 0;
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //读取 使用read,单个字符读取
            while ((data = fileReader.read()) != -1) {
                System.out.print((char) data);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 单个字符数组读取文件
     */
    @Test
    public void readFile02() {
        String filePath = "src/textFiles/story.txt";
        FileReader fileReader = null;

        int readLen = 0;
        char[] buf = new char[8];
        //1. 创建FileReader对象
        try {
            fileReader = new FileReader(filePath);
            //读取 使用read(buf), 返回的是实际读取到的字符数
            //如果返回-1，说明到文件结束了
            while ((readLen = fileReader.read(buf)) != -1) {
                System.out.print(new String(buf, 0, readLen));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
