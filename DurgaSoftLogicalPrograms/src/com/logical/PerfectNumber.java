package com.logical;

public class PerfectNumber {
	public static void main(String[] args) {
		int n=123,s=0,i;
		for(i=1;i<n;i++) {
			if(n%i==0)
				s+=i;
		}
		System.out.println(s==n);
		
	}

}
