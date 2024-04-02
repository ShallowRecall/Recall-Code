package com.hspedu.springboot.mybatisplus.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hspedu.springboot.mybatisplus.bean.Monster;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZhouYu
 * @version 1.0
 * 解读：
 * 1. BaseMapper已经默认提供了很多的crud方法，可以直接使用
 * 2. 如果BaseMapper 提供的方法不能满足业务需求，我们可以再开发新的方法，
 *    并在MonsterMapper.xml进行配置 => 使用插件开发
 */
//@Mapper
public interface MonsterMapper extends BaseMapper<Monster> {
    // 自定义方法
    // 增加一个添加的方法insert

    int insertSelective(Monster monster);

    int delByEmail(@Param("email") String email);

}
