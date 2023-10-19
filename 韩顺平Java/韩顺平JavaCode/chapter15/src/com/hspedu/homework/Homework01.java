package com.hspedu.homework;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {

    }

    @Test
    public void testList() {
        //说明
        //这我们给T 指定类型是User
        DAO<User> userDAO = new DAO<>();
        userDAO.save("001", new User(1, 10, "jack"));
        userDAO.save("002", new User(2, 18, "king"));
        userDAO.save("003", new User(3, 38, "smith"));

        List<User> list = userDAO.list();

        System.out.println("list=" + list);
        userDAO.update("003", new User(3, 58, "milan"));
        userDAO.delete("001");//删除以后
        System.out.println("===修改后===");
        list = userDAO.list();
        System.out.println("list=" + list);

        System.out.println("id=003" + userDAO.get("003"));
    }
}
/**
 * 思路分析:
 * 1. 定义User类
 * 2.定义Dao<T>泛型类
 */