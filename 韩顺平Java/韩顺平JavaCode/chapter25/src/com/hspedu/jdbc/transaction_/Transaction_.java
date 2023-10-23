package com.hspedu.jdbc.transaction_;

import com.hspedu.jdbc.utils.JDBCUtils;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @author Zhou Yu
 * @version 1.0
 * 演示jdbc 中如何使用事务
 */
public class Transaction_ {

    //没有使用事务
    @Test
    public void noTransaction() {

        //操作转账的业务
        //1. 得到连接
        Connection connection = null;

        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();// 在默认情况下，connection是默认自动提交
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第一条sql

            int i = 1 / 0; //抛出异常
            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();// 执行第二条sql


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }

    @Test
    //事务来解决
    public void useTransaction() {
        //操作转账的业务
        //1. 得到连接
        Connection connection = null;

        //2. 组织一个sql
        String sql = "update account set balance = balance - 100 where id = 1";
        String sql2 = "update account set balance = balance + 100 where id = 2";
        PreparedStatement preparedStatement = null;
        //3.创建PreparedStatement 对象
        try {
            connection = JDBCUtils.getConnection();// 在默认情况下，connection是默认自动提交
            //将 connection 设置为不自动提交
            connection.setAutoCommit(false);// 开启了事务
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate(); // 执行第一条sql

//            int i = 1 / 0; //抛出异常

            preparedStatement = connection.prepareStatement(sql2);
            preparedStatement.executeUpdate();// 执行第二条sql

            //这里提交事务
            connection.commit();

        } catch (SQLException e) {
            //这里我们可以进行回滚，即撤销执行的sql
            //默认回滚到事务开始的状态.
            System.out.println("执行发生了异常，回滚，撤销执行的SQL");
            try {
                connection.rollback();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
            e.printStackTrace();
        } finally {
            //关闭资源
            JDBCUtils.close(null, preparedStatement, connection);
        }
    }
}
