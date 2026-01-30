package com.interview;

public class SumUsingRecursion {
	public static void main(String[] args) {
		int no=9876;
		System.out.println(getSingle(no));
		
	}
	static int sumofDigit(int n)
	{
		if(n==0) {
			return 0;
		}
		return (n%10)+ sumofDigit(n/10);
	}
	static int getSingle(int n) {
		if(n<10) {
			return n;
		}
		
		int sum=sumofDigit(n);
		return getSingle(sum);
	}

	
}
