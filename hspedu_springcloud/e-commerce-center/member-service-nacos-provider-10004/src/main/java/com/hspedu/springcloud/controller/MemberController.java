package com.hspedu.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.hspedu.springcloud.entity.Member;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.handler.CustomGlobalBlockHandler;
import com.hspedu.springcloud.handler.CustomGlobalFallbackHandler;
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

    private static int num = 0;//执行的计数器-static静态

    /**
     * value = "t6" 表示 sentinel限流资源的名字
     * blockHandlerClass = CustomGlobalBlockHandler.class ： 全局限流处理类
     * blockHandler = "handlerMethod1" : 指定使用全局限流处理类哪个方法，来处理限流
     * fallbackClass = CustomGlobalFallbackHandler.class：全局fallback处理类
     * fallback = "fallbackHandlerMethod1"：指定使用全局fallback处理类哪个方法，来处理java异常/业务异常
     * exceptionsToIgnore = {RuntimeException.class}：表示如果t6()抛出RuntimeException，就使用系统默认方式处理
     *
     * @return
     */
    //这里我们使用全局限流处理类，显示限流信息
    @GetMapping("/t6")
    @SentinelResource(value = "t6",
            fallbackClass = CustomGlobalFallbackHandler.class,
            fallback = "fallbackHandlerMethod1",
            blockHandlerClass = CustomGlobalBlockHandler.class,
            blockHandler = "handlerMethod1",
            exceptionsToIgnore = {NullPointerException.class})
    public Result t6() {
        //假定：当访问t6资源次数是5的倍数时，就出现java异常
        if (++num % 5 == 0) {
            throw new NullPointerException("null指针异常 num=" + num);
        }
        if (num % 6 == 0) {//当访问t6资源次数是6的倍数时，抛出 runtime异常
            throw new RuntimeException("num的值异常 num=" + num);
        }
        log.info("执行t6() 线程id={}", Thread.currentThread().getId());
        return Result.success("200", "t6()执行OK~~");
    }

    //完成对热点key限流的测试 /news?id&type=x

    /**
     * 解读
     * 1. @SentinelResource：指定sentinel限流资源
     * 2. value = “news” 表示sentinel限流资源 名称，由程序员指定
     */
    @GetMapping("/news")
    @SentinelResource(value = "news", blockHandler = "newsBlockHandler")
    public Result queryNews(@RequestParam(value = "id", required = false) String id,
                            @RequestParam(value = "type", required = false) String type) {
        //在实际开发中，新闻应该到DB或者缓存获取,这里就是简单的模拟
        log.info("到DB 查询新闻");
        return Result.success("返回id=" + id + " 新闻 from DB");
    }

    //热点key限制/限流异常处理方法
    public Result newsBlockHandler(String id, String type,
                                   BlockException blockException) {
        return Result.success("查询id=" + id + " 新闻 触发热点key限流保护 sorry...");
        //return Result.error("401","查询id=" + id + " 新闻 触发热点key限流保护 sorry...");
    }


    //设计一个测试案例-满足异常数的阈值，触发限流机制
    @GetMapping("/t5")
    public Result t5() {
        //解读
        //出现10次异常，这里需要设置大于6，需要留出几次做测试和加入族点链路
        if (++num <= 10) {
            // 制造一个异常
            System.out.println(3 / 0);
        }
        log.info("熔断降级测试[异常数] 执行t5() 线程id={}",
                Thread.currentThread().getId());
        return Result.success("t5()执行了...");
    }

    @GetMapping("/t4")
    public Result t4() {
        //设置异常比例达到50%
        if (++num % 2 == 0) {
            //制造一个异常
            System.out.println(3 / 0);
        }
        log.info("熔断降级测试[异常比例] 执行t4() 线程id={}",
                Thread.currentThread().getId());
        return Result.success("t4()执行...");
    }

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
        log.info("执行t2() 线程id={}", Thread.currentThread().getId());
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
