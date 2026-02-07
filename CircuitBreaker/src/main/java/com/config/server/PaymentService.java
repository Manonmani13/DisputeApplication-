package com.config.server;

import org.springframework.stereotype.Service;

@Service
public class PaymentService {

	private int count=0;
	
	public String pay() {
		count++;
		if(count<=5) {
			throw new RuntimeException("Payment service Down");
		}
		return "Payment Sucessful";
	}
}
