package com.logical;

import java.util.Scanner;

public class ReplaceCharacterWithOccurence {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		char ch=s.charAt(0);
		int c=1;
		for(int i=0;i<s.length();i++) {
			if(s.charAt(i)==ch)
				System.out.print(c++);
			else
				System.out.print(s.charAt(i));
		}
		
	}

}
