package com.hspedu.springcloud.dao;

import com.hspedu.springcloud.entity.Member;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Mapper
public interface MemberDao {

    //定义方法
    //根据id放回member数据
    public Member queryMemberById(Long id);
    //添加member
    public int save(Member member);
}
