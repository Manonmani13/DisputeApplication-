package com.logical;

import java.util.Scanner;

public class CheckDigit {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,c=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)>='0'&& s.charAt(i)<='9') {
				c++;
			}
		}
		System.out.println(c==s.length()?"Yes":"No");
	}
}
