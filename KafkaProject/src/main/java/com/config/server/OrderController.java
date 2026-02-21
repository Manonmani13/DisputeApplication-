package com.config.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderProducer producer ;

	public OrderController(OrderProducer prod) {
		this.producer=prod;
	}
    @PostMapping
    public String createOrder(@RequestBody Order order) {
        producer.sendOrder(order);
        return "Order sent to Kafka successfully!";
    }
}