package com.config.server;


public class OrderEvent {
	  private String orderId;
	    private OrderStatus status;
		public String getOrderId() {
			return orderId;
		}
		public void setOrderId(String orderId) {
			this.orderId = orderId;
		}
		public OrderStatus getStatus() {
			return status;
		}
		public void setStatus(OrderStatus status) {
			this.status = status;
		}
		public OrderEvent(String orderId, OrderStatus status) {
			super();
			this.orderId = orderId;
			this.status = status;
		}
	    
	    
}
