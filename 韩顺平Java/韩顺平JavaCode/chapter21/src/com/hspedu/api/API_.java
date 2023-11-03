package com.hspedu.api;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author ZhouYu
 * @version 1.0
 * 演示InetAddress 类的使用
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {


        //1. 获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);//zhouyudeMacBook-Air.local/127.0.0.1

        //2. 根据指定主机名 获取 InetAddress对象
        InetAddress host1 = InetAddress.getByName("zhouyudeMacBook-Air.local");
        System.out.println("host1=" + host1);//zhouyudeMacBook-Air.local/127.0.0.1

        //3. 根据域名返回 InetAddress对象，比如 www.baidu.com 对应
        InetAddress host2 = InetAddress.getByName("www.baidu.com");
        System.out.println("host2=" + host2);//www.baidu.com / 180.101.50.242

        //4. 通过 InetAddress 对象，获取对应的地址
        String hostAddress = host2.getHostAddress();//IP 180.101.50.242
        System.out.println("host2 对应的ip = " + hostAddress);// 180.101.50.242

        //5. 通过 InetAddress 对象，获取对应的主机名/或者是域名
        String hostName = host2.getHostName();
        System.out.println("host2对应的主机名/域名=" + hostName);
    }
}
