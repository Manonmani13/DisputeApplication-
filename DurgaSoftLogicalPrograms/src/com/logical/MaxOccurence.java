package com.logical;

import java.util.Scanner;

public class MaxOccurence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int a[]=new int[256];
		int i,max=0;
		for(i=0;i<s.length();i++)
			a[(int)s.charAt(i)]++;
		for(i=0;i<256;i++)
		{
			if(a[i]>a[max])
				max=i;
		}
		System.out.println((char)max);
	}

}
