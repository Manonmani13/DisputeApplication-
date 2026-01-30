package com.logical;

import java.util.Scanner;

public class ReplaceString {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine().toLowerCase();
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)>='a' &&s.charAt(i)<='z')
				System.out.print(s.charAt(i)-96+" ");
		}
	}

}
