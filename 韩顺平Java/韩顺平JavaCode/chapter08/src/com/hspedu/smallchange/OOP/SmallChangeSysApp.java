package com.hspedu.smallchange.OOP;

import com.hspedu.smallchange.SmallChangeSys;

/**
 *  这里我们直接调用SmallChangeSysOOP 的对象，显示主菜单即可
 */
public class SmallChangeSysApp {
    public static void main(String[] args) {
        System.out.println("====hello公司====");
        new SmallChangeSysOOP().mainMenu();
    }
}
