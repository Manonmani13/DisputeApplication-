package com.config.server;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    StringRedisTemplate redis;

    public String placeOrder(Long userId, Double amount) {

        // Distributed lock
        Boolean lock = redis.opsForValue()
                .setIfAbsent("lock:order:" + userId, "1", 5, TimeUnit.SECONDS);

        if (Boolean.FALSE.equals(lock)) {
            return "Order already in progress";
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setAmount(amount);
        orderRepository.save(order);

        // Leaderboard
        redis.opsForZSet()
             .incrementScore("leaderboard", userId.toString(), amount);

        // Stream
        redis.opsForStream().add(
            "orders",
            Map.of("orderId", order.getId().toString(),
                   "amount", amount.toString())
        );

        return "Order placed";
    }
}

