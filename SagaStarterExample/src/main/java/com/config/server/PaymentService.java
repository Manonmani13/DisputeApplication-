package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository repository;

    public boolean processPayment(String orderId) {
        try {
            Payment payment = new Payment();
            payment.setOrderId(orderId);
            payment.setAmount(500);
            payment.setStatus("SUCCESS");

            repository.save(payment);

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void refundPayment(String orderId) {
        repository.findById(orderId).ifPresent(payment -> {
            payment.setStatus("REFUNDED");
            repository.save(payment);
        });
    }
   
}

