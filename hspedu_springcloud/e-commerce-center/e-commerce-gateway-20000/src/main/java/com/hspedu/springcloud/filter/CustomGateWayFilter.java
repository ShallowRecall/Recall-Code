//package com.hspedu.springcloud.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilter;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.Ordered;
//import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Component;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
///**
// * @author ZhouYu
// * @version 1.0
// */
//@Component
//public class CustomGateWayFilter implements GlobalFilter, Ordered {
//    //filter是核心的方法，将我们的过滤业务，写在该方法中
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println("------CustomGateWayFilter------");
//        //先过去到对应的参数值
//        //比如 http://localhost:20000/member/get/1?name=recall&pwd=123456
//        String user =
//                exchange.getRequest().getQueryParams().getFirst("user");
//        String pwd = exchange.getRequest().getQueryParams().getFirst("pwd");
//        if (!("recall".equals(user) && "123456".equals(pwd))) { //如果不满足条件
//            System.out.println("------非法用户------");
//            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);//回应
//            return exchange.getResponse().setComplete();
//        }
//        //验证通过，放行
//        return chain.filter(exchange);
//    }
//
//    //order 表示过滤器执行的顺序，数字越小，优先级越高
//    @Override
//    public int getOrder() {
//        return 0;
//    }
//}
