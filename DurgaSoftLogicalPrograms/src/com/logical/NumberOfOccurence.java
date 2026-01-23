package com.logical;

public class NumberOfOccurence {
	public static void main(String[] args) {
		int n=983479878;
		int k=8,count=0;
		while(n!=0) {
			int d=n%10;
			if(d==k) {
				count++;
			}
			n/=10;
		}
		System.out.println(k+" "+count);
	}

}
