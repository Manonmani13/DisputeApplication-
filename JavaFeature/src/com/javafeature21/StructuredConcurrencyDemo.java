package com.javafeature21;

import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrencyDemo {
	public static void main(String[] args) {
		try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
            var result1 = scope.fork(() -> "Hello");
            var result2 = scope.fork(() -> "World");
//            scope.join(); // Wait all
            System.out.println(result1+ " " + result2);
        }
	}

}
