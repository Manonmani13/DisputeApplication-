package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping
    ("/{userId}/{amount}")
    public String order(@PathVariable Long userId,
                        @PathVariable Double amount) {
        return orderService.placeOrder(userId, amount);
    }
}

