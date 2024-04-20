package com.hspedu.springcloud.service.impl;

import com.hspedu.springcloud.dao.OrderDao;
import com.hspedu.springcloud.entity.Order;
import com.hspedu.springcloud.service.AccountService;
import com.hspedu.springcloud.service.OrderService;
import com.hspedu.springcloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    @Override
    /**
     * 解读：
     * 1. @GlobalTransactional：分布式全局事务控制 io.seata.spring.annotation.GlobalTransactional
     * 2. name = "recall-save-order" 名称，程序员自己指定，保证唯一即可
     * 3. rollbackFor = Exception.class 指定发生什么异常就回滚，这里指定的是 Exception.class
     *    即 只要发生异常就回滚
     */
    @GlobalTransactional(name = "recall-save-order",rollbackFor = Exception.class)
    public void save(Order order) {

        log.info("====创建订单 start=====");

        log.info("====本地生成订单 start====");
        orderDao.save(order);//调用本地方法生成订单order
        log.info("====本地生成订单 end====");

        log.info("====扣减库存 start====");
        //远程调用storage微服务扣减库存
        storageService.reduce(order.getProductId(), order.getNums());
        log.info("====扣减库存 end====");

        log.info("====扣减用户余额 start====");
        //远程调用account 微服务扣减用户money
        accountService.reduce(order.getUserId(), order.getMoney());
        log.info("====扣减用户余额 end====");

        log.info("====本地修改订单状态 start====");
        //调用本地方法修改订单状态0->1
        orderDao.update(order.getUserId(), 0);
        log.info("====本地修改订单状态 end====");

        log.info("====创建订单 end=====");

    }
}
