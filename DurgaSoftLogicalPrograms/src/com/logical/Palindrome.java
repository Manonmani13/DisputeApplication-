package com.logical;

public class Palindrome {
	public static void main(String[] args) {
		int n=1111;
		int temp=n, r=0;
		
		while(n!=0) {
			int d=n%10;
			r=r*10+d;
			n/=10;
			
		}
		System.out.println(temp==r?"Yes":"No");
	}

}
