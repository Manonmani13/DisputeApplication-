package com.java8features;

import java.util.List;
import java.util.stream.IntStream;

public class ParallelStreamExample {
	public static void main(String[] args) {
		List<Integer> numbers=IntStream.rangeClosed(1, 10000)
				.boxed()
				.toList();
		long start = System.currentTimeMillis();
		numbers.stream().map(n -> n * n).forEach(n -> {});
		System.out.println("Sequential time: " +
		        (System.currentTimeMillis() - start));

		// Parallel
		start = System.currentTimeMillis();
		numbers.parallelStream().map(n -> n * n).forEach(n -> {});
		System.out.println("Parallel time: " +
		        (System.currentTimeMillis() - start));
		
	}

}
