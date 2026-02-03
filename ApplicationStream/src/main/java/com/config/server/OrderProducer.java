package com.config.server;

import java.util.function.Supplier;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class OrderProducer {

	 @Bean
	    public Supplier<OrderEvent> orderSupplier() {
	        return () -> new OrderEvent(1001L, "ORDER_CREATED");
	    }
}
