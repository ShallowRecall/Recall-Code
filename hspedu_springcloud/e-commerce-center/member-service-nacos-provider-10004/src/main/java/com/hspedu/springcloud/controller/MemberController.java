package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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

    @GetMapping("/t1")
    public Result t1() {
        return Result.success("t1()执行..");
    }

    @GetMapping("/t2")
    public Result t2() {
        //让线程休眠1s，模拟执行时间为1s
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //输出线程信息
        log.info("执行t2() 线程id={}",Thread.currentThread().getId());
        return Result.success("t2()执行..");
    }

    @GetMapping("/t3")
    public Result t3() {
        //让线程休眠300ms，模拟执行时间
        try {
            TimeUnit.MILLISECONDS.sleep(300);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return Result.success("t3()执行..");
    }

    //添加方法/接口

    @PostMapping("/member/save")
    public Result save(@RequestBody Member member) {
        log.info("service-provider member={}", member);
        int affected = memberService.save(member);
        if (affected > 0) { //说明添加成功
            return Result.success("添加会员成功 member-service-nacos-provider-10004", affected);
        } else {
            return Result.error("401", "添加会员失败");
        }
    }

    //查询的方法/接口
    //使用url占位符+@PathVariable
    @GetMapping("/member/get/{id}")
    public Result getMemberById(@PathVariable("id") Long id, HttpServletRequest request) {
   /* //通过?携带参数方式
    @GetMapping(value = "/member/get",params = "id")
    public Result getMemberById(Long id) {*/

        /*String color = request.getParameter("color");
        String address = request.getParameter("address");*/
        try {
            //模拟超时，让线程休眠1秒
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 输出线程的情况
        log.info("enter 10004 getMemberById 当前线程id={} 时间={}",
                Thread.currentThread().getId(), new Date());

        Member member = memberService.queryMemberById(id);

        //使用Result把查询到的结果返回
        if (member != null) {
            //return Result.success("查询会员成功 member-service-provider-10000 " + color + "-" + address, member);
            return Result.success("查询会员成功 member-service-nacos-provider-10004 ", member);
        } else {
            return Result.error("402", "ID=" + id + "不存在");
        }
    }

}
