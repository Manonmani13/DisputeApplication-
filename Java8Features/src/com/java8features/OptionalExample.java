package com.java8features;

import java.util.Optional;

public class OptionalExample {
	public static void main(String[] args) {
		Optional<String> name=Optional.ofNullable("Manonmani");
		name.ifPresent(n->System.out.println(n));
		String result=name.orElse("Name");
		System.out.println(result);
	}

}
