package com.config.server;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Provider running on port " +
                System.getProperty("server.port");
    }
}
