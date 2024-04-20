package com.hspedu.springcloud.service.impl;

import com.hspedu.springcloud.dao.StorageDao;
import com.hspedu.springcloud.service.StorageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;
    @Override
    public void reduce(Long productId, Integer nums) {
        log.info("==========seata_storage_micro_service-10010 扣减库存 start==========");
        storageDao.reduce(productId,nums);
        log.info("==========seata_storage_micro_service-10010 扣减库存 end==========");
    }
}
