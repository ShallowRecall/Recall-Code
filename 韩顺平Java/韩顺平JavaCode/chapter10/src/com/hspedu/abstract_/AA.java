package com.hspedu.abstract_;

public class AA extends Template{

    //计算任务
    //1+....+800000
    @Override
    public void job() {//实现Template的抽象方法job
        long num = 0;
        for (long i = 0; i < 800000; i++) {
            num += i;
        }
    }

}
