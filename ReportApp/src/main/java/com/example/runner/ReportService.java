package com.example.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ReportService {

	
	private ReportDAo report;
	
	@Value("${report.type}")
	private String type;

    ReportService(ReportDAo reportAppApplication) {
        this.report = reportAppApplication;
    }
	
	@Autowired
	public void setReportDAo(ReportDAo reportDA) {
		System.out.println("inside setter");
		this.report=reportDA;
	}
	
	public void printName(Integer id) {
		System.out.println("Report type "+type);
		String name=report.getNameById(id);
		System.out.println(name);
	}

}
