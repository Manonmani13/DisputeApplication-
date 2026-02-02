package com.java8features;

import java.util.function.Supplier;

public class ConstructorReference {
	public static void main(String[] args) {
		Supplier<Student> supplier=Student ::new;
		supplier.get();
	}

}

class Student {
    Student() {
        System.out.println("Student object created");
    }
}