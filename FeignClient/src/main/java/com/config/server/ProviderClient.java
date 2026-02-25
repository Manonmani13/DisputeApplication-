package com.config.server;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "greetapp")
public interface ProviderClient {

    @GetMapping("/hello")
    String getMessage();
}
