package com.config.server;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

public class Employee {


    private int id;
    private String name;
    private double salary;
    private double tax;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	
    
    
}

