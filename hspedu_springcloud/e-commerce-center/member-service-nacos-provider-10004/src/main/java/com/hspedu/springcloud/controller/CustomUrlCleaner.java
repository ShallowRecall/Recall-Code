package com.hspedu.springcloud.controller;

import com.alibaba.csp.sentinel.adapter.servlet.callback.UrlCleaner;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author ZhouYu
 * @version 1.0
 */
@Component
public class CustomUrlCleaner implements UrlCleaner {
    @Override
    public String clean(String originUrl) { // 资源清洗

        //isBlank方法是判断 originUrl != null && 有长度 && originUrl不是全部为 空格
        if (StringUtils.isBlank(originUrl)){
            return originUrl;
        }
        if (originUrl.startsWith("/member/get")){//如果得到url是以/member/get开头，进行处理
            //解读
            //1. 如果请求的接口 是 /member/get 开头，比如 /member/get/1，/member/get/10...
            //2. 给sentinel 返回资源名为 /member/get/*
            //3. 在sentinel 对 /member/get/* 添加流控规则即可
            return "/member/get/*";
        }
        return originUrl;
    }
}
