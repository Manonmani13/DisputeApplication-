package com.stream.programs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateFind {
	public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,2,5,3,6,7,1);

        Set<Integer> set=new HashSet<>();
        numbers.stream().filter(n->!set.add(n)).collect(Collectors.toSet());
        
        System.out.println(set);
	}

}
