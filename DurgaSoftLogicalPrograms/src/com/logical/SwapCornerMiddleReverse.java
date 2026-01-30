package com.logical;

import java.util.Scanner;

public class SwapCornerMiddleReverse {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s[]=sc.nextLine().split(" ");
		System.out.println(s[s.length-1]+" ");
		for(int i=s.length-1;i>=1;i--) {
			System.out.println(new StringBuffer(s[i]).reverse()+" ");
		}
		System.out.println(s[0]);
	}

}
