package com.logical;

import java.util.Scanner;

public class FirstNVowels {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int n=s.length();
		StringBuffer sb=new StringBuffer();
		for(int i=0;i<s.length();i++) {
			char ch=s.charAt(i);
			if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
				sb.append(ch);
		}
		if(n>sb.length()) {
			System.out.println("Invalid ");
		}
		else {
			for(int i=0;i<n;i++) {
				System.out.println(sb.charAt(i));
			}
		}
	}

}
