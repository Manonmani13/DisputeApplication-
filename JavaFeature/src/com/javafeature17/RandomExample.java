package com.javafeature17;

import java.util.random.RandomGenerator;

public class RandomExample {
	 public static void main(String[] args) {
	        RandomGenerator gen = RandomGenerator.of("L64X128MixRandom");
	        System.out.println(gen.nextInt(100));
	    }
}
