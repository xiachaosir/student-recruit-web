package com.student.recruit.controller;

import com.student.recruit.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis controller 测试用.
 * Created by xiachao on 2017/3/8.
 */
@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @Autowired
    private JedisPool jedisPool;

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

    @RequestMapping("/jedis/set")
    public void set(String value) {
        Jedis jedis = jedisPool.getResource();
        jedis.set("jedisname", value);
    }

    @RequestMapping("/jedis/get")
    public String get() {
        Jedis jedis = jedisPool.getResource();
        String value = jedis.get("jedisname");
        return value;
    }

}
