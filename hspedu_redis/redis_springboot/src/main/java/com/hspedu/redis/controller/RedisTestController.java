package com.hspedu.redis.controller;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/redisTest")
public class RedisTestController {

    // 装配RedisTemplate
    @Resource
    private RedisTemplate redisTemplate;

    // 编写第一个测试方法
    // 演示设置数据和获取数据
    @GetMapping("/t1")
    public String t1() {

        // 设置值到redis
        redisTemplate.opsForValue().set("book", "天龙八部");
        // 从redis获取值
        String book = (String) redisTemplate.opsForValue().get("book");
        return book;
    }

    // 编写方法，演示如何操作list,hash,set,zset
    @GetMapping("/t2")
    public String t2() {
        //list-存
        redisTemplate.opsForList().leftPush("books", "笑傲江湖");
        redisTemplate.opsForList().leftPush("books", "hello,java");


        //list-取
        List books = redisTemplate.opsForList().range("books", 0, -1);
        String bookList = "";
        for (Object book : books) {
            System.out.println("book ==> " + book.toString());
            bookList += book.toString() + " ";
        }
        //hash
        //redisTemplate.opsForHash().put();
        //set
        //redisTemplate.opsForSet().
        //zset
        //redisTemplate.opsForZSet().
        return bookList;
    }

    // 编写一个方法，获取所有的key
    @GetMapping("/t3")
    public String t3(){
        Set keys = redisTemplate.keys("*");
        for (Object key : keys) {
            System.out.println("key ==> " + key.toString());
        }
        return "ok";
    }

    //编写方法，获取通过客户端添加的数据~
    @GetMapping("/t4")
    public String t4(){

        String val = (String) redisTemplate.opsForValue().get("book");

        System.out.println("val ==> " + val);

        return val;
    }
}
