package com.logical2;

import java.util.Scanner;

public class StudentRewarded {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int c=0;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)=='A')
				c++;
		}
		if(c>1||s.contains("LLL"))
			System.out.println("No");
		else
			System.out.println("Yes");
	}

}
