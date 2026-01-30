package com.logical;

import java.util.Scanner;

public class JewlesAndStones {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String jw=sc.nextLine();
		String s=sc.nextLine();
		int i,j,c=0;
		for(i=0;i<jw.length();i++) {
			for(j=0;j<s.length();j++) {
				if(jw.charAt(i)==s.charAt(j)) {
					c++;
				}
			}
			
		}
		System.out.println(c);
	}

}
