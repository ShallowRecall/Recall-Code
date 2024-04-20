package com.hspedu.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Mapper
public interface AccountDao {
    void reduce(@Param("userId")Long userId, @Param("money") Integer money);
}
