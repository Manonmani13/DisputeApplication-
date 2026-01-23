package com.logical;

public class NumberOfDigits {
	public static void main(String[] args) {
		int n=13123;
		int count=0;
		while(n!=0) {
			n/=10;
			count++;
		}
		System.out.println(count);
	}

}
