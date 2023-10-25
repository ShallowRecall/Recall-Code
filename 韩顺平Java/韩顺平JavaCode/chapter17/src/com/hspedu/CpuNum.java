package com.hspedu;

/**
 * @author Zhou Yu
 * @version 1.0
 */
public class CpuNum {
    public static void main(String[] args) {

        Runtime runtime = Runtime.getRuntime();
        //获取当前电脑cpu数量/核心数
        int cpuNums = runtime.availableProcessors();
        System.out.println("当前有cpu 个数=" + cpuNums);

    }
}
