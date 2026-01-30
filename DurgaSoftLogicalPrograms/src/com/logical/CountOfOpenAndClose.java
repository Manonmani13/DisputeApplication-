package com.logical;

import java.util.Scanner;

public class CountOfOpenAndClose {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,c=0;
		for(i=0;i<s.length();i++) {
			if(s.charAt(i)=='(') c++;
			if(s.charAt(i)==')') c--;
		}
		System.out.println(c);
	}

}
