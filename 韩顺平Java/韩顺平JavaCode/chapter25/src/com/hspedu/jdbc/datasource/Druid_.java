package com.hspedu.jdbc.datasource;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.util.Properties;

/**
 * @author ZhouYu
 * @version 1.0
 * 测试druid使用
 */
public class Druid_ {

    @Test
    public void testDruid() throws Exception {
        //1. 加入 Druid jar包
        //2. 加入配置文件
        //3. 创建Properties对象，读取配置文件
        Properties properties = new Properties();
        properties.load(new FileInputStream("src/druid.properties"));

        long start = System.currentTimeMillis();
        //4. 创建一个指定参数的数据库连接池，Druid连接池
        DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        for (int i = 0; i < 5000; i++) {
            Connection connection = dataSource.getConnection();
            connection.close();
        }
        long end = System.currentTimeMillis();
        System.out.println("druid 耗时：" + (end - start));

    }
}
