package com.logical;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailPattern {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		Pattern p=Pattern.compile("[a-z]+[0-9]_gmail[.]com");
		Matcher m=p.matcher(s);
		if(m.find() && m.group().equals(m)) {
			System.out.println("true");
		}
		else {
			System.out.println("false");
		}
		
	}

}
