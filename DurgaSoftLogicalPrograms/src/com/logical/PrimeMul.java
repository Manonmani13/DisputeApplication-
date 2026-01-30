package com.logical;

import java.util.Scanner;

public class PrimeMul {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt(), n2=sc.nextInt(),s=0,i=0;
		for( i=n1;i<=n2;i++) {
			if(isprime(i))
				s=s+i;
		}
		System.out.println(s);
	}
	
	static boolean isprime(int n) {
		int f=0;
		for(int i=1;i<=n;i++) {
			if(n%i==0)
				f++;
			
		}
		return f==2;
	}

}
