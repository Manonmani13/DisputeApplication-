package com.stream.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HighestSalaryEmployee {

	public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
	                new Employee(1,"John",50000),
	                new Employee(2,"Alice",70000),
	                new Employee(3,"Bob",90000)
	        );
		 Employee empl=employees.stream().max(Comparator.comparing(e->e.salary)).orElse(null);
		 System.out.println(empl.name);
	}
}

class Employee {

    int id;
    String name;
    double salary;

    Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }
}