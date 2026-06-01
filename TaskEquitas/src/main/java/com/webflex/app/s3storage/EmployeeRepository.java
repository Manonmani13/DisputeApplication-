package com.webflex.app.s3storage;


import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.webflex.app.s3storage.Employee;

import reactor.core.publisher.Flux;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, Long> {
	@Query("SELECT * FROM employee")
	Flux<Employee> findAll();
}