package com.hspedu.springboot;

import com.hspedu.springboot.bean.Furn;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 * 在Springboot开发测试类
 */

@SpringBootTest
public class ApplicationTests {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Test
    public void contextLoads() {

        BeanPropertyRowMapper<Furn> rowMapper =
                new BeanPropertyRowMapper<>(Furn.class);

        List<Furn> furns = jdbcTemplate.query("select * from furn", rowMapper);
        for (Furn furn : furns) {
            System.out.println(furn);
        }

        //[HiKariDatasource]
        System.out.println(jdbcTemplate.getDataSource());
    }
}
