package com.logical;

import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt(),i,f=0;
		for(i=1;i<=n;i++) {
			if(n%i==0) {
				f++;
			}
		}
		System.out.println(f==2);
	}

}
