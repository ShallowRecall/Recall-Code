package com.hspedu.springcloud.service.Impl;

import com.hspedu.springcloud.dao.AccountDao;
import com.hspedu.springcloud.service.AccountService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Service
@Slf4j
public class AccountServiceImpl implements AccountService {

    @Resource
    AccountDao accountDao;

    @Override
    public void reduce(Long userId, Integer money) {
        log.info("========seata_account_micro_service-10012 扣减账户余额 start======");
        accountDao.reduce(userId, money);
        log.info("========seata_account_micro_service-10012 扣减账户余额 end======");
    }
}
