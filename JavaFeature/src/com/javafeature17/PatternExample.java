package com.javafeature17;

public class PatternExample {
	public static void print(Object obj) {
        if (obj instanceof String s) {
            System.out.println(s.toUpperCase());
        }
    }
	public static void main(String[] args) {
		print("Hello");
	}
}
