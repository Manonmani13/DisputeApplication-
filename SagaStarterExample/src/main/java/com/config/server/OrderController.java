package com.config.server;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class OrderController {
	private final KafkaTemplate<String, OrderEvent> kafkaTemplate;
	
	public OrderController(KafkaTemplate<String, OrderEvent> kafkaTemplate ) {
		this.kafkaTemplate=kafkaTemplate;
	}
	
	@Autowired
	PaymentService service;
	 @PostMapping
	    public String createOrder() {
	        String orderId = UUID.randomUUID().toString();

	        OrderEvent event = new OrderEvent(orderId, OrderStatus.CREATED);
	        kafkaTemplate.send("order-events", event);

	        return "Order Created: " + orderId;
	    }
	 
	 @KafkaListener(topics = "order-events", groupId = "payment-group")
	 public void processPayment(OrderEvent event) {

	     if (event.getStatus() == OrderStatus.CREATED) {
	         boolean success = service.processPayment(event.getOrderId());

	         if (success) {
	             event.setStatus(OrderStatus.PAID);
	         } else {
	             event.setStatus(OrderStatus.CANCELLED);
	         }

	         kafkaTemplate.send("payment-events", event);
	     }
	 }
	 @KafkaListener(topics = "inventory-events", groupId = "payment-group")
	 public void rollbackPayment(OrderEvent event) {

	     if (event.getStatus() == OrderStatus.CANCELLED) {
	         service.refundPayment(event.getOrderId());
	         System.out.println("Payment refunded for order " + event.getOrderId());
	     }
	 }


}
