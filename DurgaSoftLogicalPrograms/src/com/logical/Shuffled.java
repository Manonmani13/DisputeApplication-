package com.logical;

import java.util.Scanner;

public class Shuffled {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i,n=s.length();
		int a[]=new int[n];
		for(i=0;i<n;i++) {
			a[i]=sc.nextInt();
		}
		int b[]=new int[n];
		for(i=0;i<n;i++)
			b[a[i]]=s.charAt(i);
		System.out.println(new String(b.toString()));
	}

}
