package com.logical2;

import java.util.Scanner;

public class PrimeNoAddition {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int i,s=0;
		int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		for(i=0;i<n;i++)
		{
			if(isprime(a[i]))
				s+=a[i];
		}
		System.out.println(s);
	}
	
	static boolean isprime(int n) {
		int i,f=0;
		for(i=0;i<=n;i++)
		{
			if(n%i==0)
				f++;
		}
		return f==2;
	}

}
