package com.hspedu.spring.aop.aspectj;

import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component //将Camera注入到spring容器
public class Camera implements UsbInterface{
    @Override
    public void work() {
        System.out.println("相机开始工作....");
    }
}
