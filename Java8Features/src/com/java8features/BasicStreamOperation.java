
package com.java8features;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BasicStreamOperation {
	public static void main(String[] args) {
		List<Integer> numbers = Arrays.asList(10, 15, 20, 25, 30);
		numbers.stream().filter(n->n>20).forEach(System.out::println);
//		numbers.stream().filter(n->n%2==0).forEach(System.out::println);
//		numbers.stream().map(n->n*2).forEach(System.out::println);
		numbers.stream().sorted((a,b)-> b-a).forEach(System.out::println);
		List<Integer> evenList =
			    numbers.stream()
			        .filter(n -> n % 2 != 0)
			        .collect(Collectors.toList());
		evenList.forEach(System.out::println);

	}

}
