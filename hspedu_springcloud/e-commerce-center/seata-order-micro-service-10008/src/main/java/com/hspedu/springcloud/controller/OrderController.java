package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Order;
import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */

@RestController
public class OrderController {

    @Resource
    private OrderService orderService;


    @GetMapping("/order/save")
    public Result save(Order order) {
        orderService.save(order);
        return Result.success("订单创建成功", null);
    }
}
