package com.java8features;

class User {
    String name;
    int age;

    User(String name, int age){
        this.name = name;
        this.age = age;
    }

    public int getAge() { return age; }
    public String getName() { return name; }
}
