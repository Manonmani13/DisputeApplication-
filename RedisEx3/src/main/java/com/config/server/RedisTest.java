package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class RedisTest {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @PostConstruct
    public void testRedis() {
        redisTemplate.opsForValue().set("redis:test", "OK");
        System.out.println(redisTemplate.opsForValue().get("redis:test"));
    }
    
    
}

