package com.javafeature14;

public class RecordExample {
public static void main(String[] args) {
	Employee emp = new Employee(101, "Alice", 50000);

    System.out.println(emp.id());
    System.out.println(emp.name());
    System.out.println(emp);
    
    
}
}
record Employee(int id, String name, double salary) {}
