package com.logical;

import java.util.Scanner;

public class RotateString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String s2=sc.nextLine();
		System.out.println((s+s).contains(s2));
	}

}
