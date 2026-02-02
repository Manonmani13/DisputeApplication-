package com.java8features;

import java.util.Arrays;
import java.util.List;

public class LambdaExample {
	public static void main(String[] args) {
		List<String> tasks= Arrays.asList("Email","Backup","Report");
		tasks.forEach(n->System.out.println(n));
		Runnable r=()->System.out.println("Running task in thread: "+Thread.currentThread().getName());
		new Thread(r).start();
		}

}
