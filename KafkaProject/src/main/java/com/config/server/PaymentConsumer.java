package com.config.server;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(topics = "order-topic", groupId = "payment-group")
    public void processPayment(Order order) {

        System.out.println("Received Order: " + order);

        if (order.getAmount() > 5000) {
            throw new RuntimeException("Payment Failed!");
        }

        System.out.println("Payment Successful for Order: " + order.getOrderId());
    }
}