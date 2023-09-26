package com.hspedu.houserent.service;

import com.hspedu.houserent.domain.House;

/**
 * HouseService.java <=> 类[业务层]
 * 定义HouseService[]，保存House对象
 * 1. 响应HouseView的调用
 * 2. 完成对房屋信息的各种操作(增删改查c[create]r[read]u[update]d[delete])
 */
public class HouseService {
    private House[] houses;//保存House对象
    private int houseNums = 1;//记录当前有多少个房屋信息
    private int idCounter = 1;//记录当前的id增长到哪个值
    public HouseService(int size){
        //new houses
        houses = new House[size];//当创建HouseService对象，指定数组大小
        //为了配合测试列表，初始化一个列表对象
        houses[0] = new House(1,"jack","112","海淀区",2000,"未出租");
    }

    //add方法，添加新对象，返回boolean
    public boolean add(House newhouse){
        //判断是否还可以继续添加()
        if (houseNums == houses.length){//不能再添加了
            System.out.println("数组已满，不能再添加了...");
            return false;
        }
        //把newHouse对象加入到，//新增加了一个房屋
        houses[houseNums++] = newhouse;
        //需要设计一个id自增长的机制,然后更新newHouse的id
        newhouse.setId(++idCounter);
        return true;
    }

    //list方法，返回houses
    public House[] list(){
        return houses;
    }
}
