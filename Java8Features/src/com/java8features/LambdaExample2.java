package com.java8features;

import java.util.Arrays;
import java.util.List;

public class LambdaExample2 {
	public static void main(String[] args) {
		List<User> users=Arrays.asList(new User("Mano",24),
				new User("Naveen",29),
				new User("mayo",23));
		users.stream().filter(n->n.age>24).forEach(n->System.out.println(n.getName()));
		
	}

}
