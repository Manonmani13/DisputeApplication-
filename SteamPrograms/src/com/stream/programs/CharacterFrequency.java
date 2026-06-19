package com.stream.programs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CharacterFrequency {
	public static void main(String[] args) {
		String name="manonmani";
		
		Map<Character,Long> map=name.chars().mapToObj(c->(char)c)
				.collect(Collectors.groupingBy(c->c,Collectors.counting()));

		System.out.println(map);
	}

}
