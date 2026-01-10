package com.business.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.app.modl.Dispute;
@Repository
public interface DisputeRepository extends JpaRepository<Dispute, Long> {
	List<Dispute> findByCustIdAndStatus(String custId, String status);

}
