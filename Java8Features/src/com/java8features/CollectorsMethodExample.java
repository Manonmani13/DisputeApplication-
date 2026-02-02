package com.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsMethodExample {
public static void main(String[] args) {
	 List<Employee> employees = Arrays.asList(
	            new Employee("Alice", 60000),
	            new Employee("Bob", 45000),
	            new Employee("Charlie", 75000),
	            new Employee("David", 50000));
	 Map<Boolean, List<Employee>> map =
			    employees.stream()
			             .collect(Collectors.partitioningBy(e -> e.salary > 50000));

			map.forEach((n, m) -> System.out.println(n + " " + m));
			
			

}
}
