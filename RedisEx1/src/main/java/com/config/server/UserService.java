package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    StringRedisTemplate redis;

    @Cacheable(value = "user", key = "#id")
    public User getUser(Long id) {
        return userRepository.findById(id).get();
    }

    public void login(Long userId, String username) {
        // Online users
        redis.opsForSet().add("online_users", username);

        // Daily active users
        redis.opsForValue()
             .setBit("login:2026-01-27", userId, true);

        // Unique visitors
        redis.opsForHyperLogLog()
             .add("visitors", userId.toString());
    }
}