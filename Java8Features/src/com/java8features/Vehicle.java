package com.java8features;

public interface Vehicle {
	 default void start() {
	        System.out.println("Vehicle is starting");
	    }
}

class Car implements Vehicle{
	
}