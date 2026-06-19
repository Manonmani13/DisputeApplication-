package com.stream.programs;

import java.util.Arrays;
import java.util.List;

public class SumExample {
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(10,20,30,40);
        System.out.println(numbers.stream().reduce(0,(a,b)->a+b));
        
	}

}
