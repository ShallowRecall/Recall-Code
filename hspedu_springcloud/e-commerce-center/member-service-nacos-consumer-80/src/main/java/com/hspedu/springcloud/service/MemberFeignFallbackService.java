package com.hspedu.springcloud.service;

import com.hspedu.springcloud.entity.Result;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component
public class MemberFeignFallbackService implements MemberOpenFeignService{
    @Override
    public Result getMemberById(Long id) {
        return Result.error("500", "被调用服务异常，熔断降级，快速返回结果，防止请求线程堆积..");
    }
}
