package com.hspedu.springcloud.service;

/**
 * @author ZhouYu
 * @version 1.0
 */
public interface AccountService {
    //扣减用户的money
    void reduce(Long userId, Integer money);
}
