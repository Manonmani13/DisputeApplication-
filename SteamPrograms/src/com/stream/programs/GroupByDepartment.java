package com.stream.programs;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDepartment {
	public static void main(String[] args) {
		 List<Emp> employees = Arrays.asList(
	                new Emp("John","IT"),
	                new Emp("Alice","HR"),
	                new Emp("Bob","IT"),
	                new Emp("David","Finance")
	        );
		Map<String,List<Emp>>gro= employees.stream().collect(Collectors.groupingBy(c->c.department));
		 gro.forEach((emp,emplist)->{
		 System.out.println(emp+" "+emplist.size());});
	}

}

class Emp {

    String name;
    String department;

    Emp(String name, String department) {
        this.name = name;
        this.department = department;
    }
}