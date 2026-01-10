package com.business.app.modl;


import java.time.Instant;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Refund {
	  
	  @Id
	  @GeneratedValue(strategy = GenerationType.AUTO)
	  private Long id;
	  
	  private Long refundID;
	
	  private Long disputeId;
	
	  private Double amount;
	
	  private Instant refundTz;
	  private String status;
	
	  private String refrenceNo;

	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
		  this.id = id;
	  }

	  public Long getRefundID() {
		  return refundID;
	  }

	  public void setRefundID(Long refundID) {
		  this.refundID = refundID;
	  }

	  public Long getDisputeId() {
		  return disputeId;
	  }

	  public void setDisputeId(Long disputeId) {
		  this.disputeId = disputeId;
	  }

	  public Double getAmount() {
		  return amount;
	  }

	  public void setAmount(Double amount) {
		  this.amount = amount;
	  }

	  public Instant getRefundTz() {
		  return refundTz;
	  }

	  public void setRefundTz(Instant refundTz) {
		  this.refundTz = refundTz;
	  }

	  public String getStatus() {
		  return status;
	  }

	  public void setStatus(String status) {
		  this.status = status;
	  }

	  public String getRefrenceNo() {
		  return refrenceNo;
	  }

	  public void setRefrenceNo(String refrenceNo) {
		  this.refrenceNo = refrenceNo;
	  }
	
	
}
