package com.logical;

public class OddishAndEvenish {
	public static void main(String[] args) {
		int n=15,s=0;
		while(n!=0) {
			s=s+(n%10);
			n/=10;
		}
		System.out.println((s%2==0)?"Evenish":"Oddish");
	}

}
