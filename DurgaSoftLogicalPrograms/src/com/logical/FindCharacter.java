package com.logical;

import java.util.Scanner;

public class FindCharacter {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		int i;
		boolean found=false;
		for(i=0;i<s.length()-1;i++) {
			if(s.charAt(i)==s.charAt(i+1)) {
				found=true;
				break;
			}
		}
		System.out.println(found);
	}

}
