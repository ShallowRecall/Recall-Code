package com.recall.furns.test;

import com.recall.furns.entity.Member;
import com.recall.furns.service.MemberService;
import com.recall.furns.service.impl.MemberServiceImpl;
import org.junit.jupiter.api.Test;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class MemberServiceTest {

    private MemberService memberService = new MemberServiceImpl();

    @Test
    public void isExistsUsername() {
        if (memberService.isExistsUsername("king")) {
            System.out.println("用户名存在...");
        } else {
            System.out.println("用户名不存在...");
        }
    }

    @Test
    public void registerMember() {
        //构建一个Member对象
        Member member = new Member(null, "mary", "mary", "mary@qq.com");
        if (memberService.registerMember(member)) {
            System.out.println("注册用户成功...");
        } else {
            System.out.println("注册用户失败...");
        }
    }
}
