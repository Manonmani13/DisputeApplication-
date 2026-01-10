package com.business.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.business.app.modl.Dispute;
import com.business.app.modl.DisputeEvent;
import com.business.app.modl.Refund;
import com.business.app.repository.DisputeEventRepository;
import com.business.app.repository.DisputeRepository;
import com.business.app.repository.RefundRepository;

import jakarta.persistence.EntityNotFoundException;
@Service
public class DisputeService {
	
	@Autowired
	DisputeRepository repo;
	
	@Autowired
	RefundRepository refundRepo;
	
	@Autowired
	DisputeEventRepository disputeRepo;


	public Dispute saveDispute(Dispute requst) {
		return repo.save(requst);
	}

	public List<Dispute> searchDisputes(String custId, String status) {
		
		return repo.findByCustIdAndStatus(custId,status);
	}

	public Dispute findOne(Long id) {
		
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("Dispute not found"));

	}

	public Refund saveRefund(Long id,Refund requst) {
		// TODO Auto-generated method stub
		Refund refund=refundRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("Refund not found"));
		if(refund!=null) {
			refund.setStatus(requst.getStatus());
		}
		return refund;
	}

	public DisputeEvent saveDisputeEvent(Long id, DisputeEvent requst) {
		DisputeEvent dispute=disputeRepo.findById(id).orElseThrow(() -> new EntityNotFoundException("DisputeEvent not found"));
		if(dispute!=null) {
			dispute.setEventType(requst.getEventType());
		}
		return dispute;
	}

}
