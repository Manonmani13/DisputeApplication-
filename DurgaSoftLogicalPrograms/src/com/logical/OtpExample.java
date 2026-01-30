package com.logical;

public class OtpExample {
	public static void main(String[] args) {
		int n=1232,p=1,d;
		while(n!=0) {
			d=n%10;
			p=p*d;
			n/=10;
		}
		System.out.println(p);
	}

}
