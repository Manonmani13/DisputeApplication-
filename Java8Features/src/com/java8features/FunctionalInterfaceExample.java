package com.java8features;

public class FunctionalInterfaceExample {
	public static void main(String[] args) {
		MyFunctionalInterface add=(a,b)->a+b;
		MyFunctionalInterface mul= (a,b) -> a*b;
		
		System.out.println("Additional "+add.operation(12, 8) +" Multi : "+mul.operation(3, 2));
	}
}
