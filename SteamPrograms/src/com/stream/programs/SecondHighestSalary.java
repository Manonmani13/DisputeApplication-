package com.stream.programs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class SecondHighestSalary {
	public static void main(String[] args) {
		 List<Integer> numbers =
	                Arrays.asList(10,20,30,40,50,60);
		 System.out.println(numbers.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst());
		 
	}

}
