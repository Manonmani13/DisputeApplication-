package com.config.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Payment {

    @Id
    private String orderId;
    private double amount;
    private String status; // SUCCESS, FAILED, REFUNDED
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Payment(String orderId, double amount, String status) {
		super();
		this.orderId = orderId;
		this.amount = amount;
		this.status = status;
	}
	public Payment() {
		super();
	}
    
    
}

