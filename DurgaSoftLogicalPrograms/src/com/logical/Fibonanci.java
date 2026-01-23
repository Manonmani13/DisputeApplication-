package com.logical;

public class Fibonanci {
public static void main(String[] args) {
	System.out.println(fib(5));
}
static int fib(int n) {
	if(n==0|| n==1)
		return n;
	else 
		return(n-1)+(n-2);
}
}
