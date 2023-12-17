package com.hspedu.spring.proxy2;

import org.junit.jupiter.api.Test;

/**
 * @author ZhouYu
 * @version 1.0
 */
public class TestVehicle {

    @Test
    public void run() {
        //OOP基础=>java基础
        Vehicle vehicle = new Ship();
        vehicle.run();
    }

    @Test
    public void proxyRun() {
        // 创建一个Ship对象
        Vehicle vehicle = new Ship();

        // 创建VehicleProxyProvider对象，并且我们传入了要代理的对象
        VehicleProxyProvider vehicleProxyProvider =
                new VehicleProxyProvider(vehicle);

        // 获取代理对象，该对象可以代理执行方法
        // 解读
        // 1. proxy 的编译类型是 Vehicle
        // 2. 运行类型 是代理类型 class com.sun.proxy.$Proxy8
        Vehicle proxy = vehicleProxyProvider.getProxy();

        System.out.println("proxy的编译类型是 Vehicle");
        System.out.println("proxy的运行类型是 " + proxy.getClass());
        // 解读怎么执行到代理对象的invoke方法
        // proxy的编译类型是 Vehicle，运行类型是 class com.sun.proxy.$Proxy8
        // 所以当执行run方法时，会执行到 代理对象的invoke
        // 如何体现动态 [1. 被代理的对象 2. 方法]
//        proxy.run();
        String result = proxy.fly(10000);
        System.out.println("result=" + result);
    }
}
