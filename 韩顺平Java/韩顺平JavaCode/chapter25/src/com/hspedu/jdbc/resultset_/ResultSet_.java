package com.hspedu.jdbc.resultset_;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @author Zhou Yu
 * @version 1.0
 * 演示select 语句返回 ResultSet，并取出结果
 */
@SuppressWarnings({"all"})
public class ResultSet_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        //通过Properties对象获取配置文件的信息
        Properties properties = new Properties();
        properties.load(new FileInputStream("src\\mysql.properties"));

        String user = properties.getProperty("user");
        String password = properties.getProperty("password");
        String driver = properties.getProperty("driver");
        String url = properties.getProperty("url");

        //1. 注册驱动
        Class.forName(driver);//建议写上

        //2. 得到连接
        Connection connection = DriverManager.getConnection(url, user, password);

        //3. 得到一个statement
        Statement statement = connection.createStatement();
        //4. 组织SQL
        String sql = "select id, name, sex, borndate from actor";
        //执行给定的SQL语句，该语句返回单个 ResultSet对象
        /*
            resultSet 对象的结构

         */
        ResultSet resultSet = statement.executeQuery(sql);



        //5. 使用while取出数据
        while (resultSet.next()) { // 让光标向后移动，如果没有更多行，则返回false
            int id = resultSet.getInt(1);//获取该行的第1列
//            int id1 = resultSet.getInt("id"); 通过列名来获取值，推荐
            String name = resultSet.getString(2);//获取该行的第2列
            String sex = resultSet.getString(3);//获取该行的第3列
            Date date = resultSet.getDate(4);
//            Object object = resultSet.getObject(1);
            System.out.println(id + "\t" + name + "\t" + sex + "\t" + date);
        }

        //6 关闭连接
        resultSet.close();
        statement.close();
        connection.close();

    }
}
