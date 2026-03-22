package com.config.server;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Payroll {

    @Id
    @GeneratedValue
    private Long id;

    private Long employeeId;
    private Double netSalary;
    private String payMonth;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Long employeeId) {
		this.employeeId = employeeId;
	}
	public Double getNetSalary() {
		return netSalary;
	}
	public void setNetSalary(Double netSalary) {
		this.netSalary = netSalary;
	}
	public String getPayMonth() {
		return payMonth;
	}
	public void setPayMonth(String payMonth) {
		this.payMonth = payMonth;
	}
    
    
}
