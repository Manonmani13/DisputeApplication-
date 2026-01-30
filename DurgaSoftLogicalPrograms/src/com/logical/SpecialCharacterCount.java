package com.logical;

import java.util.Scanner;

public class SpecialCharacterCount {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int count=0;
		for(int i=0;i<s.length();i++) {
			char c=s.charAt(i);
			if(c>='a'&& c<='z'||c>='A'&&c<='Z'||c>=0 && c<=9) {
				continue;
			}
			else
				count++;
		}
		System.out.println(count);
		
	}

}
