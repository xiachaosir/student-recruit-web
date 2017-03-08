package com.student.recruit.controller;

import com.student.recruit.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Redis controller 测试用.
 * Created by xiachao on 2017/3/8.
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping("/redis/set")
    public boolean redisSet(String value) {
        boolean isOk = redisService.set("name", value);
        return isOk;
    }

    @RequestMapping("/redis/get")
    public String redisGet() {
        String value = redisService.get("name");
        return value;
    }
}
