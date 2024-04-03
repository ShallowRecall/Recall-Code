package com.hspedu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
@Slf4j
@RefreshScope //spring cloud原生注解，实现了配置数据的自动刷新
public class NacosConfigClientController {

    /**
     * 解读
     * 1. client 会拉取nacos server 的 e-commerce-nacos-config-client-dev.yaml
     * config:
     *     ip: "122.22.22.22"
     *     name: "Recall"
     * 2. @Value("${config.ip}") 会将 config.ip 赋给 configIp
     * 3. 这里${config.ip} 不能乱写，要有依据
     */
    @Value("${config.ip}")
    private String configIp;

    @Value("${config.name}")
    private String configName;

    @GetMapping("/nacos/config/ip")
    public String getConfigIp() {
        return configIp;
    }

    @GetMapping("/nacos/config/name")
    public String getConfigName() {
        return configName;
    }
}
