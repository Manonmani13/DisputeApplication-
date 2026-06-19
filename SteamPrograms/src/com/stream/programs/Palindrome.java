package com.stream.programs;

import java.util.Arrays;
import java.util.List;

public class Palindrome {
	public static void main(String[] args) {
		 List<String> words=Arrays.asList(
	                "madam","java","level","spring","radar"
	        );
		 
		 List<String> re=words.stream().filter(w->w.equals(new StringBuffer(w).reverse().toString()))
				 .toList();
		 System.out.println(re);
	}

}
