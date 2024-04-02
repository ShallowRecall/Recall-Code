package com.hspedu.springboot.mybatisplus;

import com.hspedu.springboot.mybatisplus.bean.Monster;
import com.hspedu.springboot.mybatisplus.mapper.MonsterMapper;
import com.hspedu.springboot.mybatisplus.service.MonsterService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SpringBootTest
public class ApplicationTest {

    @Resource
    private MonsterMapper monsterMapper;

    @Resource
    private MonsterService monsterService;

    @Test
    public void testMonsterMapper() {

        Monster monster = monsterMapper.selectById(2);
        System.out.println("monster--" + monster);
    }

    @Test
    public void testMonsterService(){
        /*Monster monster = monsterService.getById(2);
        System.out.println("monster==" + monster);*/
        List<Monster> list = monsterService.list();
        for (Monster monster1 : list) {
            System.out.println(monster1);
        }
    }

}
