package com.java8features;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamRealTimeExample {
	public static void main(String[] args) {
		 List<Employee> employees = Arrays.asList(
		            new Employee("Alice", 60000),
		            new Employee("Bob", 45000),
		            new Employee("Charlie", 75000),
		            new Employee("David", 50000)
		        );
		 employees.stream().filter(e->e.salary>50000)
		 .sorted(Comparator.comparingDouble(e->e.salary))
		 .map(e->e.name)
		 .forEach(System.out::println);
	}

}
