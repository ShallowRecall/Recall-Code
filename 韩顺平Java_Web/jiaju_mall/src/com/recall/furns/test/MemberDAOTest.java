package com.recall.furns.test;

import com.recall.furns.dao.MemberDAO;
import com.recall.furns.dao.impl.MemberDAOImpl;
import com.recall.furns.entity.Member;
import org.junit.jupiter.api.Test;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class MemberDAOTest {

    private MemberDAO memberDAO = new MemberDAOImpl();

    @Test
    public void queryMemberByUsername() {

        if (memberDAO.queryMemberByUsername("admin") == null) {
            System.out.println("该用户名不存在...");
        } else {
            System.out.println("该用户名存在...");
        }
    }

    @Test
    public void saveMember() {

        Member member =
                new Member(null, "king", "king", "king@sohu.com");
        if (memberDAO.saveMember(member) == 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败...");
        }
    }
}
