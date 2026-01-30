package com.logical;

import java.util.Scanner;

public class MatchString {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	String s=sc.nextLine();
	String r1="qwertyuiop";
	String r2="asdfghj";
	String r3="zxcvbnm";
	int i=0,j=0,c1=0,c2=0,c3=0;
	for( i=0;i<s.length();i++) {
		for(j=0;j<r1.length();i++) {
			if(s.charAt(i)==r1.charAt(j)) c1++;
		}
		for(j=0;j<r2.length();i++) {
			if(s.charAt(i)==r2.charAt(j)) c2++;
		}
		for(j=0;j<r3.length();i++) {
			if(s.charAt(i)==r3.charAt(j)) c3++;
		}
	}
	System.out.println(c1==s.length()|| c2==s.length() ||c3==s.length());
}
}
