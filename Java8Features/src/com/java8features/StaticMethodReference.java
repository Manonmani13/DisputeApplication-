package com.java8features;

import java.util.Arrays;
import java.util.List;

public class StaticMethodReference {
	public static void main(String[] args) {
		List<String> names=Arrays.asList("mano","naveen","chandar");
		names.forEach(StaticMethodReference::printMessage);
	}
	
	public static void printMessage(String msg) {
		System.out.println(msg);
	}

}
