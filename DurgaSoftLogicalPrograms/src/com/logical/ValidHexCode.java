package com.logical;

import java.util.Scanner;

public class ValidHexCode {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println(sc.nextLine().matches("#[A-fa-f0-9]{6}"));
	}

}
