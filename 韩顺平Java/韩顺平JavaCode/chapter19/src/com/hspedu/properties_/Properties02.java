package com.hspedu.properties_;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Zhou Yu
 * @version 1.0
 */
public class Properties02 {
    public static void main(String[] args) throws IOException {
        //使用Properties 类完成对 mysql.properties 的读取

        //1. 创建Properties 对象
        Properties properties = new Properties();
        //2. 加载指定配置文件
        properties.load(new FileReader("src/mysql.properties"));
        //3. 把k-v对显示
        properties.list(System.out);
        //4. 根据key 获取对应的值
        String user = properties.getProperty("user");
        String pwd = properties.getProperty("pwd");
        System.out.println("用户名=" + user);
        System.out.println("密码=" + pwd);


    }
}
