package com.java8features;

import java.util.Arrays;
import java.util.List;

public class InstanceMethodRef {
	public static void main(String[] args) {
		InstanceMethodRef ref=new InstanceMethodRef();
		List<String> langs=Arrays.asList("Java","c","C++","Spring Boot");
		langs.forEach(ref::display);
		
	}
	
	public void display(String msg) {
		System.out.println(msg);
	}

}
