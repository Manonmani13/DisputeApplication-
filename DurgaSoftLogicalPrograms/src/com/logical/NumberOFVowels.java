package com.logical;

import java.util.Scanner;

public class NumberOFVowels {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,c=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)=='a'|| s.charAt(i)=='e' || s.charAt(i)=='i' ||s.charAt(i)=='o'|| s.charAt(i)=='u') {
				c++;
			}
		}
		System.out.println(c);
	}

}
