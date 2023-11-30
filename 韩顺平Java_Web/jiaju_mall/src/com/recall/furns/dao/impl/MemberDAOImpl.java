package com.recall.furns.dao.impl;

import com.recall.furns.dao.BasicDAO;
import com.recall.furns.dao.MemberDAO;
import com.recall.furns.entity.Member;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class MemberDAOImpl extends BasicDAO<Member> implements MemberDAO {


    /**
     * 通过用户名返回对应的Member
     *
     * @param username 用户名
     * @return 对应的Member，如果没有该Member，返回 null
     */
    @Override
    public Member queryMemberByUsername(String username) {

        String sql = "SELECT `id`, `username`, `password`, `email`\n" +
                "FROM `member`\n" +
                "WHERE `username` = ? ";

        return querySingle(sql, Member.class, username);
    }

    /**
     * 保存一个会员
     *
     * @param member 传入Member对象
     * @return 返回-1 就是失败，返回其它的数字就是受影响的行数
     */
    @Override
    public int saveMember(Member member) {
        String sql = "INSERT INTO `member`(`username`, `password`, `email`) " +
                "VALUES (?, MD5(?), ?)";
        return update(sql, member.getUsername(),
                member.getPassword(), member.getEmail());
    }
}
