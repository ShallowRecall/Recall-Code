package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.concurrent.TimeUnit;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Slf4j
@RestController
public class MemberController {

    // 装配MemberService
    @Resource
    public MemberService memberService;

    //添加方法/接口

    @PostMapping("/member/save")
    public Result save(@RequestBody Member member) {
        log.info("service-provider member={}", member);
        int affected = memberService.save(member);
        if (affected > 0) { //说明添加成功
            return Result.success("添加会员成功 member-service-nacos-provider-10006", affected);
        } else {
            return Result.error("401", "添加会员失败");
        }
    }

    //查询的方法/接口
    //使用url占位符+@PathVariable
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id, HttpServletRequest request) {

        /*String color = request.getParameter("color");
        String address = request.getParameter("address");*/
        /*try {
            //模拟超时，休眠5秒
            TimeUnit.MICROSECONDS.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }*/

        Member member = memberService.queryMemberById(id);

        //使用Result把查询到的结果返回
        if (member != null) {
            //return Result.success("查询会员成功 member-service-provider-10000 " + color + "-" + address, member);
            return Result.success("查询会员成功 member-service-nacos-provider-10006 ", member);
        } else {
            return Result.error("402", "ID=" + id + "不存在");
        }
    }

}
