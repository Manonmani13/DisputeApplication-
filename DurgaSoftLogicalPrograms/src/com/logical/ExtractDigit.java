package com.logical;

public class ExtractDigit {
	public static void main(String[] args) {
		int n=1213;
		while(n!=0) {
			int d=n%10;
			System.out.print(d+" ");
			n/=10;
		}
	}

}
