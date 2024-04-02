//package com.hspedu.springcloud.config;
//
//import com.netflix.loadbalancer.IRule;
//import com.netflix.loadbalancer.RandomRule;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author ZhouYu
// * @version 1.0
// * RibbonRule：配置类-配置自己的负载均衡算法
// */
//@Configuration
//public class RibbonRule {
//
//    //配置注入自己的负载均衡算法
//    @Bean
//    public IRule myRibbonRule() {
//        //这里返回的是RandomRule，可以根据需求返回不同的负载均衡算法
//        return new RandomRule();
//    }
//}
