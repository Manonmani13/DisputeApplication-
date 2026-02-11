package com.javafeature21;

public class PatternMatching {
	public static void main(String[] args) {
		Object obj = "Hello";

		String result = switch (obj) {
		    case Integer i -> "Integer " + i;
		    case String s  -> "String " + s;
		    default        -> "Unknown";
		};

		System.out.println(result);

	}

}
