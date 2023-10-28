package com.hspedu.file;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class Directory_ {
    public static void main(String[] args) {

        //
    }

    //判断 src/textFiles/news1.txt 是否存在，如果存在删除
    @Test
    public void m1() {

        String filePath = "src/textFiles/news1.txt";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该文件不存在...");
            try {
                file.createNewFile();
                System.out.println("创建成功");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //判断 src/textFiles/demo2 是否存在，存在删除,否则提示不存
    //在java编程中，目录也被当做文件
    @Test
    public void m2() {

        String filePath = "src/textFiles/demo02";
        File file = new File(filePath);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println(filePath + "删除成功");
            } else {
                System.out.println(filePath + "删除失败");
            }
        } else {
            System.out.println("该目录不存在...");
        }
    }

    //判断 src/textFiles/demo/a/b/c 目录是否存在，如果存在就提示已经存在，否则就创建
    @Test
    public void m3() {

        String directoryPath = "src/textFiles/demo/a/b/c";
        File file = new File(directoryPath);
        if (file.exists()) {
            System.out.println(file.getName() + "已经存在...");
        } else {
            System.out.println("该目录不存在...");
            if (file.mkdirs()) {
                System.out.println(directoryPath + "该目录创建成功");
            } else {
                System.out.println(directoryPath + "该目录创建失败");
            }
        }
    }

}
