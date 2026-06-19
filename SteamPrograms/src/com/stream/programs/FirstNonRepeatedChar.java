package com.stream.programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class FirstNonRepeatedChar {
	public static void main(String[] args) {
		String input="aabbcdeff";
		Character chara=input.chars().mapToObj(c->(char) c)
				.collect(Collectors.groupingBy(c->c,LinkedHashMap::new,Collectors.counting()))
				.entrySet()
				.stream()
				.filter(k->k.getValue()==1)
				.map(Map.Entry::getKey)
				.findFirst()
				.orElse(null);
		System.out.println(chara);
				
	}

}
