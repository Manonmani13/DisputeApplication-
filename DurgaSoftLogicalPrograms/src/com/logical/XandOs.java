package com.logical;

import java.util.Scanner;

public class XandOs {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,xc=0,oc=0;
		for( i=0;i<s.length();i++) {
			if(s.charAt(i)=='x')xc++;
			if(s.charAt(i)=='o') oc++;
		}
		System.out.println(xc==oc);
	}

}
