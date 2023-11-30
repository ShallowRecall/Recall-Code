package com.recall.furns.dao;

import com.recall.furns.entity.Member;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface MemberDAO {

    //提供一个通过用户名返回对应的Member

    public Member queryMemberByUsername(String username);

    //提供一个保存Member对象到数据库/表member表
    public int saveMember(Member member);

}
