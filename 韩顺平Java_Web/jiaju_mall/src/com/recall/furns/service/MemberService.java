package com.recall.furns.service;

import com.recall.furns.entity.Member;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface MemberService {

    //注册用户
    public boolean registerMember(Member member);

    //判断用户名是否存在
    public boolean isExistsUsername(String username);
}
