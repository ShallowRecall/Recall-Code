package com.hspedu.springcloud;

import com.hspedu.springcloud.dao.MemberDao;
import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@SpringBootTest
@Slf4j
public class MemberApplication10000Test {

    // 装配MemberDao
    @Resource
    private MemberDao memberDao;

    // 装配MemberService
    @Resource
    private MemberService memberService;

    //这里的@Test org.junit.jupiter.api.Test;
    @Test
    public void queryMemberById() {
        //Member member = memberDao.queryMemberById(1L);
        Member member = memberService.queryMemberById(1L);
        log.info("member = {}", member);
    }

    @Test
    public void save() {
        Member member = new Member(null, "狐狸精", "123456", "15527672729", "hlj@qq.com", 1);
        //int affected = memberDao.save(member);
        int affected = memberService.save(member);
        log.info("affected~~ = {}", affected);
    }
}
