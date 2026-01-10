package com.business.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.business.app.modl.DisputeEvent;
@Repository
public interface DisputeEventRepository extends JpaRepository<DisputeEvent, Long>{


}
