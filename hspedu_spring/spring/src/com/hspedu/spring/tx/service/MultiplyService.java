package com.hspedu.spring.tx.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Service
public class MultiplyService {
    @Resource
    private GoodsService goodsService;

    /**
     * 解读：
     * 1. multiBuyGoodsByTx 这个方法 有两次购买商品操作
     * 2. buyGoodsByTX 和 buyGoodsByTX2 都是声明式事务
     * 3. 当前buyGoodsByTX 和 buyGoodsByTX2 使用的传播属性是默认的 REQUIRED
     *    [会当做一个整体事务进行管理，比如buyGoodsByTx方法成功，但是buyGoodsByTx2() 失败，会造成整个事务的回滚
     *    即会回滚buyGoodsByTx]
     *
     * 4. 如果  buyGoodsByTX 和 buyGoodsByTX2 事务传播属性修改成 REQUIRES_NEW
     *    ，这时两个方法的事务是独立的，也就是说如果buyGoodsByTX成功，buyGoodsByTX2()失败，不会造成buyGoodsByTX()回滚
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW,isolation = Isolation.DEFAULT)
    public void multiBuyGoodsByTx() {

        goodsService.buyGoodsByTX(1, 1, 1);
        goodsService.buyGoodsByTX2(1, 1, 1);
    }
}
