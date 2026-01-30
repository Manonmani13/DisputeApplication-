package com.logical;

import java.util.Scanner;

public class SumOfSequence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int i,j,k,s;
		i=sc.nextInt();
		j=sc.nextInt();
		k=sc.nextInt();
		s=0;
		while(i<=j) {
			s=s+(i++);
		}
		while(j!=k) {
			s=s+(--j);
		}
		System.out.println(s);
	}

}
