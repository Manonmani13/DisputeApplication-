package com.business.app.modl;


import java.time.Instant;

import jakarta.annotation.Generated;
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
public class Dispute {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long txId;
	
	private Long custId;
	
	private String disputeType;
	
	private Double claimAmount;
	
	private String actor;
	
	private String status;
	private Instant createdAt;
	
	private Instant updatedAt;


}
