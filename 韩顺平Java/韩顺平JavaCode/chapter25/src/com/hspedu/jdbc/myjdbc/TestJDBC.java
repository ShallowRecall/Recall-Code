package com.hspedu.jdbc.myjdbc;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class TestJDBC {
    public static void main(String[] args) {
        //完成对mysql的操作
        JdbcInterface jdbcInterface = new MysqlJdbcImpl();//修改这里就行了
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定机制]
        jdbcInterface.crud();
        jdbcInterface.close();

        //完成对oracle的操作
        System.out.println("===========================");
        jdbcInterface = new OracleJdbcImpl();
        jdbcInterface.getConnection(); //通过接口来调用实现类[动态绑定机制]
        jdbcInterface.crud();
        jdbcInterface.close();
    }
}
