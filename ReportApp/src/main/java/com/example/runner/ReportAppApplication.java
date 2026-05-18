package com.example.runner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class ReportAppApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext cont= SpringApplication.run(ReportAppApplication.class, args);
		ReportService ser=cont.getBean(ReportService.class);
		ser.printName(100);
	}

}
