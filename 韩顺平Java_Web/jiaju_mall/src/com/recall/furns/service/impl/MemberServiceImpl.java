package com.recall.furns.service.impl;

import com.recall.furns.dao.MemberDAO;
import com.recall.furns.dao.impl.MemberDAOImpl;
import com.recall.furns.entity.Member;
import com.recall.furns.service.MemberService;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class MemberServiceImpl implements MemberService {
    //定义一个MemberDao属性
    private MemberDAO memberDAO = new MemberDAOImpl();

    @Override
    public boolean registerMember(Member member) {
        return memberDAO.saveMember(member) == 1 ? true : false;
    }

    /**
     * 判断用户名是否存在
     *
     * @param username 用户名
     * @return 如果存在返回true，否则返回false
     */
    @Override
    public boolean isExistsUsername(String username) {
        return memberDAO.queryMemberByUsername(username) == null ? false : true;
    }
}
