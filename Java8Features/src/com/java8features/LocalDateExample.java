package com.java8features;

import java.time.LocalDate;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate specificDate = LocalDate.of(2025, 1, 10);
        System.out.println(specificDate);

        System.out.println(today.plusDays(5));
        System.out.println(today.minusMonths(1));
	}

}
