package com.hspedu.springcloud.service;

import org.springframework.stereotype.Service;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface StorageService {
    //扣减库存
    void reduce(Long productId, Integer nums);
}
