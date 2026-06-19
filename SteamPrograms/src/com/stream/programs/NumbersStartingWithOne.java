package com.stream.programs;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class NumbersStartingWithOne {
	public static void main(String[] args) {
		 List<Integer> numbers =
	                Arrays.asList(10,21,13,45,11,98,100);
		 
		 List<String> starts=numbers.stream().map(String::valueOf).filter(n-> n.startsWith("1"))
				 .collect(Collectors.toList());
		 System.out.println(starts);
	
	}

}
