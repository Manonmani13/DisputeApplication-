package com.config.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class OrderController {

    private final PaymentService paymentService;

    public OrderController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }
    
    @GetMapping("/order")
    @CircuitBreaker(name="paymentService",fallbackMethod="paymentFallback")
    @Retry(name="paymentService")
    public String payment() {
    	return paymentService.pay();
    }
    public String paymentFallback(Exception ex) {
        return "Payment service unavailable. Order placed in PENDING state.";
    }
}
