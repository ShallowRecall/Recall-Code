package com.recall.furns.test;

import com.recall.furns.utils.JDBCUtilsByDruid;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class JDBCUtilsByDruidTest {

    @Test
    public void getConnection() throws SQLException {

        Connection connection = JDBCUtilsByDruid.getConnection();
        System.out.println("connection= " + connection);
        JDBCUtilsByDruid.close(null, null, connection);
    }
}
