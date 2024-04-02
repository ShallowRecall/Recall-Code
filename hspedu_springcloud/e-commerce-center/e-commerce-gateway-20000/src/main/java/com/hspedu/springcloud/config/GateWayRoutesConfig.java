//package com.hspedu.springcloud.config;
//
//import org.springframework.cloud.gateway.route.RouteLocator;
//import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
///**
// * @author ZhouYu
// * @version 1.0
// * GateWayRoutesConfig：配置类-配置路由
// */
//@Configuration
//public class GateWayRoutesConfig {
//
//    //配置注入路由
//
//    /**
//     * 在理解通过配置类注入/配置 路由，可以对照前面的application.yml来对比理解
//     */
//    @Bean
//    public RouteLocator myRouteLocator04(RouteLocatorBuilder routeLocatorBuilder) {
//
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        //1. 下面的方法我们分别指定了id，uri 和path
//        //2. Function<PredicateSpec, Route.AsyncBuilder> fn
//        //(1) 是一个函数式接口
//        //(2) 接收的类型是 PredicateSpec ，返回的类型是 Route.AsyncBuilder
//        //(3) r -> r.path("/member/get/**")
//        //                .uri("http://localhost:10000") 就是lambda表达式
//        //(4) 用代码进行说明-先使用-再理解
//        //3. 这是一个规定的写法
//
//        return routes.route("member_route04", r -> r.path("/member/get/**")
//                .uri("http://localhost:10000"))
//                .build();
//    }
//
//    @Bean
//    public RouteLocator myRouteLocator05(RouteLocatorBuilder routeLocatorBuilder) {
//
//        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
//
//        return routes.route("member_route04", r -> r.path("/member/save")
//                        .uri("http://localhost:10000"))
//                .build();
//    }
//}
