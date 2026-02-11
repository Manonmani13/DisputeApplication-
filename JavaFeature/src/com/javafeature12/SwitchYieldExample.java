package com.javafeature12;

public class SwitchYieldExample {
    public static void main(String[] args) {
        int marks = 85;

        String grade = switch (marks / 10) {
            case 9, 10:
                yield "A";
            case 8:
                yield "B";
            case 7:
                yield "C";
            default:
                yield "Fail";
        };

        System.out.println(grade);
    }
}

