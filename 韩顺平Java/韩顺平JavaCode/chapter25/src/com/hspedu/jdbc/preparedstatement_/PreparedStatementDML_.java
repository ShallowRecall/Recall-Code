package com.hspedu.jdbc.preparedstatement_;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;
import java.util.Scanner;

/**
 * @author Zhou Yu
 * @version 1.0
 * 演示PreparedStatement使用 dml
 */
@SuppressWarnings({"all"})
public class PreparedStatementDML_ {
    public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);

        //让用户输入管理员名和密码
        System.out.print("请输入管理员的名字：");//next(): 当接收到 空格或者 '就是表示结束
        String admin_name = scanner.nextLine();// 说明，如果希望看到SQL注入，这里需要用nextLine
//        System.out.print("请输入管理员的新密码：");
//        String admin_pwd = scanner.nextLine();

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


        //3. 得到一个PreparedStatement
        //3.1组织SQL,sql 语句的 ？ 就相当于占位符
        //添加记录
        //String sql = "insert into admin values (?,?)";
        //修改记录
        //String sql = "update admin set pwd = ? where name=?";
        //删除记录
        String sql = "delete from admin where name=?";
        //3.2preparedStatement 对象实现了 PreparedStatement 接口的实现类的对象
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        //3.3 给 ？ 赋值
        //preparedStatement.setString(1, admin_pwd);
        //preparedStatement.setString(2, admin_name);
        preparedStatement.setString(1,admin_name);

        //4. 执行 dml 语句使用 executeUpdate
        int rows = preparedStatement.executeUpdate();
        System.out.println(rows > 0 ? "执行成功" : "执行失败");

        //关闭连接
        preparedStatement.close();
        connection.close();
    }
}
