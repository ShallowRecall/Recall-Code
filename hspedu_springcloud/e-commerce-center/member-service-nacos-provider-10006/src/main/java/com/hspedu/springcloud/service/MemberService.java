package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Member;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface MemberService {
    // 根据id返回member
    public Member queryMemberById(Long id);

    // 添加member
    public int save(Member member);
}
