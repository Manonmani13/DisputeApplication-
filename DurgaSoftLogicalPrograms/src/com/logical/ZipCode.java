package com.logical;

import java.util.Scanner;

public class ZipCode {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		try {
			int n=Integer.parseInt(s);
			System.out.println(n>9999 && n<100000);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
