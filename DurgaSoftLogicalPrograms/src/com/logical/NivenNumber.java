package com.logical;

public class NivenNumber {
	public static void main(String[] args) {
		int n=123,sum=0,temp=n;
		while(n!=0) {
			int d=n%10;
			sum+=d;
			n/=10;
		}
		System.out.println(temp%sum==0?"Yes":"No");
	}

}
