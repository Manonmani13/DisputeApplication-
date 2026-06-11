package com.config.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;

@RestController
public class OrderController {

  private final Counter orderCounter;

  public OrderController(MeterRegistry registry) {
    this.orderCounter = registry.counter("orders.created");
  }

  @GetMapping("/order")
  public String createOrder() {
    orderCounter.increment();
    return "Order Created";
  }
}

