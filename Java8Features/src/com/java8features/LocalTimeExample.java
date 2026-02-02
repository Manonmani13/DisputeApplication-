package com.java8features;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class LocalTimeExample {
	 public static void main(String[] args) {

	        LocalTime now = LocalTime.now();
	        System.out.println(now);

	        LocalTime time = LocalTime.of(10, 30);
	        System.out.println(time);

	        System.out.println(now.plusHours(2));
	        
	        LocalDateTime ldt=LocalDateTime.now();
	        System.out.println(ldt);
	        
	        DateTimeFormatter formatter =
	                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	        System.out.println(ldt.format(formatter));
	        
	        ZonedDateTime indiaTime =
	                ZonedDateTime.now(ZoneId
	                		.of("Asia/Kolkata"));

	        ZonedDateTime usTime =
	                ZonedDateTime.now(ZoneId.of("America/New_York"));

	        System.out.println(indiaTime);
	        System.out.println(usTime);
	        
	    }
}
