package com.example.runner;

import org.springframework.stereotype.Repository;

@Repository
public class ReportDAo {
	
	public String getNameById(Integer userId) {
		if(userId==100) {
			return "Mano";
		} else if(userId==101) {
			return "Manonmani";
		} else {
			return "Name not found";
		}
	}

}
