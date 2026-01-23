package com.logical;

import java.util.Scanner;

public class DateOfBirth {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int day=sc.nextInt();
		if(s.equals("oct") && day==13) {
			System.out.println(1);
		}
		else {
			System.out.println(0);
		}
	}

}
