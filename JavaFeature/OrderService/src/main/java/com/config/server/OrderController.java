package com.config.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Value("${app.discount}")
    private int discount;

  
    @GetMapping("/config")
    public String readConfig() {
    	System.out.println(discount);
        return
               ", Discount=" + discount;
    }
}
