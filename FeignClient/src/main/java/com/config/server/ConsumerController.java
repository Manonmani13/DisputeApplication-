package com.config.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consume")
public class ConsumerController {

    private final ProviderClient providerClient;

    public ConsumerController(ProviderClient providerClient) {
        this.providerClient = providerClient;
    }

    @GetMapping("/message")
    public String consumerMessage() {
        return providerClient.getMessage();
    }
}

