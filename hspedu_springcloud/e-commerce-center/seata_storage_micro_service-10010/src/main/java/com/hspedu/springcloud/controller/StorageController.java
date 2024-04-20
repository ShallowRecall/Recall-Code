package com.hspedu.springcloud.controller;

import com.hspedu.springcloud.entity.Result;
import com.hspedu.springcloud.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ZhouYu
 * @version 1.0
 */
@RestController
public class StorageController {

    @Autowired
    private StorageService storageService;

    //扣减库存
    @PostMapping("/storage/reduce")
    public Result reduce(@RequestParam("productId") Long productId, @RequestParam("nums") Integer nums) {

        storageService.reduce(productId, nums);

        return Result.success("扣减库存成功 ok", null);
    }
}
