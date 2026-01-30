package com.logical;

import java.util.Scanner;

public class MaxDigit {

	static int maxDigits(int n) {
		int m=0,d;
		while(n!=0) {
			d=n%10;
			if(d>m) {
				m=d;
			}
			n/=10;
		}
		return m;
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n1=sc.nextInt();
		int n2=sc.nextInt();
		int n3=sc.nextInt();
		int w=Math.min(Math.min(n1%10,n2%10),n3%10);
		int x=Math.min(Math.min((n1%10)%10,(n2%10)%10),(n3%10)%10);
		int y=Math.min(Math.min((n1%100)%10,(n2%100)%10),(n3%100)%10);
		int z=Math.max(Math.max(maxDigits(n1), maxDigits(n2)),maxDigits(n3));
		System.out.println(z*1000+y*100+x*10+w);
		

	}
}
