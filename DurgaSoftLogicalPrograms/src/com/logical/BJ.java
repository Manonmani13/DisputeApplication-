package com.logical;

import java.util.Scanner;

public class BJ {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		System.out.println(BJME(n1,n2));
	}

	private static int BJME(int n1, int n2) {
		// TODO Auto-generated method stub
		if(n1>21 && n2>21)
			return 0;
		else if(n1>21)
			return n2;
		else if(n2>21)
			return n1;
		return Math.max(n1, n2);
	}

}
