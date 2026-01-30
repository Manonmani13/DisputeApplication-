package com.logical;

import java.util.Scanner;

public class BlackWhite {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int  x=s.charAt(0)-96;
		int y=s.charAt(1);
		System.out.println(x%2!=y%2);
	}

}
